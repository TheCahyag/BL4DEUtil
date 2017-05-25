package com.servegame.bl4de.BL4DEUtil.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;

/**
 * File: Ranks.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class Ranks implements CommandExecutor {

    /**
     * CommandResults TODO
     * @param src TODO
     * @param args TODO
     * @return TODO
     * @throws CommandException TODO
     */
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        src.sendMessage(Text.of("Hello world"));
        return CommandResult.success();
    }
}
