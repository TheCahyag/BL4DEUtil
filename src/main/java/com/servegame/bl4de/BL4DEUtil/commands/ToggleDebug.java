package com.servegame.bl4de.BL4DEUtil.commands;

import com.servegame.bl4de.BL4DEUtil.BL4DEUtil;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

/**
 * File: ToggleDebug.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class ToggleDebug implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        BL4DEUtil.debug = !BL4DEUtil.debug;
        src.sendMessage(Text.of(TextColors.AQUA, "Debug mode has been set to: " + BL4DEUtil.debug));
        return CommandResult.success();
    }
}
