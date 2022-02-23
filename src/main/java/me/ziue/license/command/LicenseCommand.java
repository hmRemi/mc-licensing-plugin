package me.ziue.license.command;

import me.ziue.api.chat.ChatUtil;
import me.ziue.api.command.BaseCommand;
import me.ziue.api.command.Command;
import me.ziue.api.command.CommandArgs;
import me.ziue.license.command.impl.LicenseCheckCommand;
import org.bukkit.entity.Player;

public class LicenseCommand extends BaseCommand {

    public LicenseCommand() {
        super();
        new LicenseCheckCommand();
    }

    @Command(name = "license")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        player.sendMessage(ChatUtil.translate("&7&m-----------------------------"));
        player.sendMessage(ChatUtil.translate("&3&lLicense Help"));
        player.sendMessage(ChatUtil.translate(""));
        player.sendMessage(ChatUtil.translate("&b/" + "license" + " check <license>"));
        player.sendMessage(ChatUtil.translate("&b/" + "license" + " reload"));
        player.sendMessage(ChatUtil.translate("&7&m-----------------------------"));
    }
}
