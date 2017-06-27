package com.servegame.bl4de.BL4DEUtil.commands.ranks;

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
        Text t1 = Text.of(TextColors.GRAY, "----------------------");
        Text t2 = Text.of(TextColors.WHITE, "[");
        Text t3 = Text.of(TextColors.GOLD, "Technician");
        Text t4 = Text.of(TextColors.WHITE, "]");
        Text t5 = Text.of(TextColors.GRAY, "--------------------\n");
        Text t6 = Text.of(TextColors.AQUA, "Requirements");
        Text t7 = Text.of(TextColors.WHITE, ": \n");
        Text t8 = Text.of(TextColors.YELLOW, "   ➊ Accrue 24 hours of playtime (/RU Check)\n");
        Text t9 = Text.of(TextColors.GREEN, "Benefits");
        Text t10 = Text.of(TextColors.WHITE, ": \n");
        Text t11 = Text.of(TextColors.YELLOW, "   ➊ Set two homes with /Sethome\n");
        Text t12 = Text.of(TextColors.YELLOW, "   ➋ Use chat formatting (not colors), /Info colors\n");
        Text t13 = Text.of(TextColors.YELLOW, "   ➌ 1000 additional claim blocks\n");
        Text t14 = Text.of(TextColors.YELLOW, "   ➍ /EC (Enderchest)\n");
        Text t15 = Text.of(TextColors.GRAY, "----------------------------------------------------");
        Text[] tmp = {t1, t2, t3, t4, t5, t6, t7, t8, t9, t10,
                t11, t12, t13, t14, t15};
        Text message = Text.builder().append(tmp).build();
        src.sendMessage(message);
        return CommandResult.success();
    }
}