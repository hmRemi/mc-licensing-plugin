package me.ziue.api.command;

import me.ziue.api.command.CommandArgs;
import me.ziue.api.command.CommandManager;

public abstract class BaseCommand {

    public BaseCommand() {
        CommandManager.getInstance().registerCommands(this, null);
    }

    public abstract void onCommand(CommandArgs command);
}
