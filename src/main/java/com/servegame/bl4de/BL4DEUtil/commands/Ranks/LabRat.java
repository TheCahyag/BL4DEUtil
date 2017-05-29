package com.servegame.bl4de.BL4DEUtil.commands.Ranks;

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
        Text t1 = Text.of(TextColors.GRAY, "----------------------");
        Text t2 = Text.of(TextColors.WHITE, "[");
        Text t3 = Text.of(TextColors.AQUA, "LabRat");
        Text t4 = Text.of(TextColors.WHITE, "]");
        Text t5 = Text.of(TextColors.GRAY, "----------------------\n");
        Text t6 = Text.of(TextColors.AQUA, "Requirements");
        Text t7 = Text.of(TextColors.WHITE, ": \n");
        Text t8 = Text.of(TextColors.YELLOW, "   ➊ Log into the server\n");
        Text t9 = Text.of(TextColors.GREEN, "Benefits");
        Text t10 = Text.of(TextColors.WHITE, ": \n");
        Text t11 = Text.of(TextColors.YELLOW, "   ➊ One home with /sethome\n");
        Text t12 = Text.of(TextColors.YELLOW, "   ➋ /Kit Starter\n");
        Text t13 = Text.of(TextColors.YELLOW, "   ➌ Teleport to a random position with /RTP\n");
        Text t14 = Text.of(TextColors.YELLOW, "   ➍ Teleport to/from players with /TPA, /TPAHere\n");
        Text t15 = Text.of(TextColors.GRAY, "----------------------------------------------------");
        Text[] tmp = {t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15};
        Text message = Text.builder().append(tmp).build();
        src.sendMessage(message);
        return CommandResult.success();
    }
}
