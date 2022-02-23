package me.ziue.license;

import lombok.Getter;
import lombok.Setter;
import me.ziue.api.chat.ChatUtil;
import me.ziue.api.command.CommandManager;
import me.ziue.api.file.type.BasicConfigurationFile;
import me.ziue.license.backend.ReturnType;
import me.ziue.license.backend.Server;
import me.ziue.license.command.LicenseCommand;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
@Setter
public class License extends JavaPlugin {

    private BasicConfigurationFile configFile;
    private ReturnType returnType;
    private Server licenseServer;

    @Override
    public void onEnable() {
        // Plugin startup logic

        initializeConfigs();
        initializeCommands();

        ChatUtil.loadPlugin();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void initializeCommands() {
        new CommandManager(this);
        new LicenseCommand();
    }

    public void initializeConfigs() {
        this.configFile = new BasicConfigurationFile(this, "config");
    }

    public static License getLicense() {
        return getPlugin(License.class);
    }
}
