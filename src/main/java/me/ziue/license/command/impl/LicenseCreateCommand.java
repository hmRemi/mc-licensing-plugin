package me.ziue.license.command.impl;

import me.ziue.api.chat.ChatUtil;
import me.ziue.api.command.BaseCommand;
import me.ziue.api.command.Command;
import me.ziue.api.command.CommandArgs;
import me.ziue.license.License;
import me.ziue.license.backend.ReturnType;
import me.ziue.license.backend.Server;
import org.bukkit.entity.Player;

public class LicenseCreateCommand extends BaseCommand {

    public String server = License.getLicense().getConfig().getString("SERVER");

    @Command(name = "license.create")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if(args.length < 4) {
            player.sendMessage(ChatUtil.translate("&cUsage: /license create <license> <plugin> <discord> <ips>"));
            return;
        }

        if(License.getLicense().getLicenseServer().getReturn() == ReturnType.VALID) {
            player.sendMessage(ChatUtil.translate("&cLicense already exists"));
            return;
        }

        if(License.getLicense().getLicenseServer().getReturn() == ReturnType.INVALID_REQUEST_KEY) {
            player.sendMessage(ChatUtil.translate("&cInvalid Request Key"));
            return;
        }

        if(License.getLicense().getLicenseServer().getReturn() == ReturnType.REQUEST_KEY_NOT_FOUND) {
            player.sendMessage(ChatUtil.translate("&cMissing Request Key"));
            return;
        }

        Server database = new Server(args[0], server, args[1], args[2], args[3]);
        database.createLicense();

        player.sendMessage(ChatUtil.translate("&eCreating license.."));
    }
}
