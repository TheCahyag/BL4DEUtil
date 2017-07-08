package com.servegame.bl4de.BL4DEUtil.commands.ranks;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

/**
 * File: LabRat.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class LabRat implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        /*
            -----------------------[LabRat]----------------------
            Requirements:
               ➊ Log into the server
            Benefits:
               ➊ Set a home with /Sethome
               ➋ /Kit Starter
               ➌ Teleport to a random position with /RTP
               ➍ Teleport to/from players with /TPA, /TPAHere
            ----------------------------------------------------
         */
        Text message = Text.builder()
                .append(Text.of(TextColors.GRAY, "-----------------------",
                        TextColors.WHITE, "[",
                        TextColors.AQUA, "LabRat",
                        TextColors.WHITE, "]",
                        TextColors.GRAY, "----------------------\n",
                        TextColors.AQUA, "Requirements",
                        TextColors.WHITE, ": \n",
                        TextColors.YELLOW, "   ➊ Log into the server",
                        TextColors.GREEN, "Benefits",
                        TextColors.WHITE, ": \n",
                        TextColors.YELLOW, "   ➊ Set a home with /Sethome\n",
                        TextColors.YELLOW, "   ➋ /Kit Starter\n",
                        TextColors.YELLOW, "   ➌ Teleport to a random position with /RTP\n",
                        TextColors.YELLOW, "   ➍ Teleport to/from players with /TPA, /TPAHere\n",
                        TextColors.GRAY, "----------------------------------------------------"))
                .build();
        src.sendMessage(message);
        return CommandResult.success();
    }
}
