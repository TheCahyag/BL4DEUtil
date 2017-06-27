package com.servegame.bl4de.BL4DEUtil.commands.getclw;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

/**
 * File: GetCLW.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class GetCLW implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (!(src instanceof Player)){
            // Check if the caller is NOT a player
            src.sendMessage(Text.of("This command is meant only for players."));
            return CommandResult.empty();
        }
        ((Player) src).sendMessage(Text.of(TextColors.AQUA,
                "In exchange for 3 emeralds, you will receive one Chunk Loading Ward " +
                        "(From ExtraUtils2). /GetCLW Confirm"));
        return CommandResult.success();
    }
}
