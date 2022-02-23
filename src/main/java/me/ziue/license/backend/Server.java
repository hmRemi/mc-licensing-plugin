package me.ziue.license.backend;

import me.ziue.license.License;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Server {

    private String license;
    private String server;
    private String plugin;

    private String requestKey = License.getLicense().getConfig().getString("REQUEST_KEY"); //"vmLAyzmppLLDgvqMPFyHLSkWdyHYqRImNueC1OLK";
    private boolean debug = false;

    private boolean valid = false;
    private ReturnType returnType;
    private String generatedBy;
    private String discord;
    private String generatedIn;
    private String ips;


    // Check license
    public Server(String license, String server, String plugin) {
        this.license = license;
        this.server = server;
        this.plugin = plugin;
    }

    // Create license
    public Server(String discord, String plugin, String license, String createdby, String createdin, String maxips, String server) {
        this.discord = discord;
        this.plugin = plugin;
        this.license = license;
        this.generatedBy = createdby;
        this.generatedIn = createdin;
        this.ips = maxips;
        this.server = server;
    }

    public void debug() {
        debug = true;
    }

    public void createLicense() {
        try {
            URL url = new URL(server + "/add.php");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void authenticateDatabase(String discord, String plugin, String license, String createdby, String createdin, String maxips, String server) {

        String user = License.getLicense().getConfig().getString("USER");
        String password = License.getLicense().getConfig().getString("PASSWORD");

        try {

            // Create connection with database
            Connection connection = DriverManager.getConnection(server, user, password);

            // Create statement
            Statement statement = connection.createStatement();

            // Execute SQL Query
            String sql = "INSERT INTO licenses " + " (DISCORD, PLUGIN, LICENSE, `CREATED-BY`, `CREATED-IN`, `MAX-IPS`)" + " values ('" + discord + "', '" + plugin + "', '" + license + "', '" + createdby + "', '" + createdin + "', '" + maxips + "')";

            statement.executeUpdate(sql);

            System.out.println(sql + " has been added.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read license and get information
    public void request() {
        try {
            URL url = new URL(server + "/request.php");
            URLConnection connection = url.openConnection();

            if (debug) System.out.println("[DEBUG] Connecting to request server: " + server + "/request.php");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

            connection.setRequestProperty("License-Key", license);
            connection.setRequestProperty("Plugin-Name", plugin/*.getDescription().getName()*/);
            connection.setRequestProperty("Request-Key", requestKey);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            if (debug) System.out.println("[DEBUG] Reading response");
            if (debug) System.out.println("[DEBUG] Converting to string");
            StringBuilder builder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            String response = builder.toString();
            if (debug) System.out.println("[DEBUG] Converted");

            String[] responseSplited = response.split(";");
            if (responseSplited[0].equals("VALID")) {
                if (debug) System.out.println("[DEBUG] VALID MYSQL");
                valid = true;
                returnType = ReturnType.valueOf(responseSplited[0]);

                generatedBy = responseSplited[2];
                generatedIn = responseSplited[3];
                discord = responseSplited[1];
            } else {
                if (debug) System.out.println("[DEBUG] FAILED VALIDATION");
                valid = false;
                returnType = ReturnType.valueOf(responseSplited[0]);

                if (debug) System.out.println("[DEBUG] FAILED WITH RESULT: " + returnType);
            }
        } catch (Exception ex) {
            if (debug) {
                ex.printStackTrace();
            }
        }
    }

    public boolean isValid() {
        return valid;
    }

    public ReturnType getReturn() {
        return returnType;
    }

    public String getDiscord() {
        return discord;
    }

    public String getIPS() {
        return ips;
    }

    public String getLicense() {
        return license;
    }

    public String getPlugin() {
        return plugin;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public String getGeneratedIn() {
        return generatedIn;
    }


    /*public enum ReturnType {
        LICENSE_NOT_FOUND, PLUGIN_NAME_NOT_FOUND, REQUEST_KEY_NOT_FOUND, INVALID_REQUEST_KEY, INVALID_LICENSE, TOO_MANY_IPS, VALID;
    }*/

}
