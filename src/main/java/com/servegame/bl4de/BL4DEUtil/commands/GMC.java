package com.servegame.bl4de.BL4DEUtil.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

/**
 * File: GMC.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class GMC implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof Player){

        } else {
            src.sendMessage(Text.of("This command is meant to be ran by players only!"));
        }
        return CommandResult.success();
    }
}
