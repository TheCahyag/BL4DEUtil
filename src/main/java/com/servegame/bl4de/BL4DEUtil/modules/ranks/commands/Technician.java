package com.servegame.bl4de.BL4DEUtil.modules.ranks.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

/**
 * File: Technician.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class Technician implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        /*
            ----------------------[Technician]--------------------
            Requirements:
               ? Accrue 24 hours of playtime (/RU Check)
            Benefits:
               ? Set two homes with /Sethome
               ? Use chat formatting (not colors), /Info colors
               ? 1000 additional claim blocks
               ? /EC (Enderchest)
            ----------------------------------------------------
         */
        Text message = Text.builder()
                .append(Text.of(TextColors.GRAY, "----------------------",
                        TextColors.WHITE, "[",
                        TextColors.GOLD, "Technician",
                        TextColors.WHITE, "]",
                        TextColors.GRAY, "--------------------\n",
                        TextColors.AQUA, "Requirements",
                        TextColors.WHITE, ": \n",
                        TextColors.YELLOW, "   ➊ Accrue 24 hours of playtime (/RU Check)\n",
                        TextColors.GREEN, "Benefits",
                        TextColors.WHITE, ": \n",
                        TextColors.YELLOW, "   ➊ Set two homes with /Sethome\n" +
                                "   ➋ Use chat formatting (not colors), /Info colors\n" +
                                "   ➌ 1000 additional claim blocks\n" +
                                "   ➍ /EC (Enderchest)\n",
                        TextColors.GRAY, "----------------------------------------------------"))
                .build();
        src.sendMessage(message);
        return CommandResult.success();
    }
}
