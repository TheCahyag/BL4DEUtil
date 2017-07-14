package com.servegame.bl4de.BL4DEUtil.modules.ranks.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

/**
 * File: Scientist.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class Scientist implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        /*
            -----------------------[Scientist]---------------------
            Requirements:
               ➊ Donate $15.00 USD
            Benefits:
               The following is subject to change
               The following is still under development, these do
               not reflect the final version of the rank
               ➊ Set three homes with /Sethome
               ➋ /Feed
               ➌ 2500 additional claim blocks
               ➍ /Back (on death)
               ➎ /Nickname
               ➏ /Kit Scientist
            ----------------------------------------------------
         */
        Text message = Text.builder()
                .append(Text.of(TextColors.GRAY, "-----------------------",
                        TextColors.WHITE, "[",
                        TextColors.DARK_BLUE, "Scientist",
                        TextColors.WHITE, "]",
                        TextColors.GRAY, "---------------------\n",
                        TextColors.AQUA, "Requirements",
                        TextColors.WHITE, ": \n",
                        TextColors.YELLOW, "   ➊ Donate ",
                        TextColors.DARK_GREEN, "$",
                        TextColors.WHITE, "15.00 ",
                        TextColors.DARK_BLUE, "USD\n",
                        TextColors.GREEN, "Benefits",
                        TextColors.WHITE, ": \n",
                        TextColors.DARK_RED, "   The following is subject to change\n",
                        TextColors.DARK_RED, "   The following is still under development, these do \n   " +
                                "not reflect the final version of the rank\n",
                        TextColors.YELLOW, "   ➊ Set three homes with /Sethome\n",
                        TextColors.YELLOW, "   ➋ /Feed\n",
                        TextColors.YELLOW, "   ➌ 2500 additional claim blocks\n",
                        TextColors.YELLOW, "   ➍ /Back (on death)\n",
                        TextColors.YELLOW, "   ➎ /Nickname\n",
                        TextColors.YELLOW, "   ➏ /Kit Scientist\n",
                        TextColors.GRAY, "----------------------------------------------------"))
                .build();
        src.sendMessage(message);
        return CommandResult.success();
    }
}
