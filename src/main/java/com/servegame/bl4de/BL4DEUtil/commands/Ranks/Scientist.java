package com.servegame.bl4de.BL4DEUtil.commands.Ranks;

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
        Text t1 = Text.of(TextColors.GRAY, "--------------------");
        Text t2 = Text.of(TextColors.WHITE, "[");
        Text t3 = Text.of(TextColors.DARK_BLUE, "Scientist");
        Text t4 = Text.of(TextColors.WHITE, "]");
        Text t5 = Text.of(TextColors.GRAY, "----------------------\n");
        Text t6 = Text.of(TextColors.AQUA, "Requirements");
        Text t7 = Text.of(TextColors.WHITE, ": \n");
        Text t8 = Text.of(TextColors.YELLOW, "   ➊ Donate ");
        Text t9 = Text.of(TextColors.DARK_GREEN, "$");
        Text t10 = Text.of(TextColors.YELLOW, "15.00 ");
        Text t11 = Text.of(TextColors.DARK_BLUE, "USD\n");
        Text t12 = Text.of(TextColors.GREEN, "Benefits");
        Text t13 = Text.of(TextColors.WHITE, ": \n");
        Text t14 = Text.of(TextColors.DARK_RED, "The following is subject to change\n");
        Text t15 = Text.of(TextColors.DARK_RED, "The following is still under development, these do \nnot reflect the final version of the rank\n");
        Text t16 = Text.of(TextColors.YELLOW, "   ➊ Set three homes with /Sethome\n");
        Text t17 = Text.of(TextColors.YELLOW, "   ➋ /Feed\n");
        Text t18 = Text.of(TextColors.YELLOW, "   ➌ 2500 additional claim blocks\n");
        Text t19 = Text.of(TextColors.YELLOW, "   ➍ /Back (on death)\n");
        Text t20 = Text.of(TextColors.YELLOW, "   ➎ /Nickname\n");
        Text t21 = Text.of(TextColors.YELLOW, "   ➏ /Kit Scientist\n");
        Text t22 = Text.of(TextColors.GRAY, "----------------------------------------------------");
        Text[] tmp = {t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22};
        Text message = Text.builder().append(tmp).build();
        src.sendMessage(message);
        return CommandResult.success();
    }
}
