package com.servegame.bl4de.BL4DEUtil.commands.Blade;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

/**
 * File: Blade.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class Blade implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Text t1 = Text.of(TextColors.GRAY, "----------------------------------------------------\n");
        Text t2 = Text.of(TextColors.DARK_RED, "BL4DE");
        Text t3 = Text.of(TextColors.DARK_GRAY, "Util\n");
        Text t4 = Text.of(TextColors.BLUE, "Author(s)");
        Text t5 = Text.of(TextColors.WHITE, ": ");
        Text t6 = Text.of(TextColors.GOLD, "TheCahyag\n");
        Text t7 = Text.of(TextColors.GREEN, "Commands");
        Text t8 = Text.of(TextColors.WHITE, ": /");
        Text t9 = Text.of(TextColors.GREEN, "Blade commands\n");
        Text t10 = Text.of(TextColors.GRAY, "----------------------------------------------------");
        Text[] tmp = {t1, t2, t3, t4, t5, t6, t7, t8, t9, t10};
        Text message = Text.builder().append(tmp).build();
        src.sendMessage(message);
        return CommandResult.success();
    }
}
