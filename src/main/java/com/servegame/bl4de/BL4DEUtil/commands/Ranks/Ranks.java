package com.servegame.bl4de.BL4DEUtil.commands.Ranks;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import javax.swing.text.TextAction;

/**
 * File: Ranks.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class Ranks implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Text t1 = Text.of(TextColors.GRAY, "----------------------------------------------------\n");
        Text t2 = Text.of(TextColors.GREEN, "Rank");
        Text t3 = Text.of(TextColors.WHITE, ": [");
        Text t4 = Text.of(TextColors.AQUA, "LabRat");
        Text t5 = Text.of(TextColors.WHITE, "]\n");
        Text t6 = Text.of(TextColors.WHITE, "   /");
        Text t7 = Text.builder("Ranks labrat\n")
                .color(TextColors.GREEN)
                .style(TextStyles.UNDERLINE)
                .onClick(TextActions.runCommand("/ranks labrat"))
                .onHover(TextActions.showText(Text.of("Click here to suggest this command")))
                .build();
        Text t8 = Text.of(TextColors.GREEN, "Rank");
        Text t9 = Text.of(TextColors.WHITE, ": [");
        Text t10 = Text.of(TextColors.GOLD, "Technician");
        Text t11 = Text.of(TextColors.WHITE, "]\n");
        Text t12 = Text.of(TextColors.WHITE, "   /");
        Text t13 = Text.builder("Ranks technician\n")
                .color(TextColors.GREEN)
                .style(TextStyles.UNDERLINE)
                .onClick(TextActions.runCommand("/ranks technician"))
                .onHover(TextActions.showText(Text.of("Click here to suggest this command")))
                .build();
        Text t14 = Text.of(TextColors.GREEN, "Rank");
        Text t15 = Text.of(TextColors.WHITE, ": [");
        Text t16 = Text.of(TextColors.DARK_BLUE, "Scientist");
        Text t17 = Text.of(TextColors.WHITE, "]\n");
        Text t18 = Text.of(TextColors.WHITE, "   /");
        Text t19 = Text.builder("Ranks scientist\n")
                .color(TextColors.GREEN)
                .style(TextStyles.UNDERLINE)
                .onClick(TextActions.runCommand("/ranks scientist"))
                .onHover(TextActions.showText(Text.of("Click here to suggest this command")))
                .build();
        Text t20 = Text.of(TextColors.GRAY, "----------------------------------------------------");
        Text[] tmp = {t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20};
        Text message = Text.builder().append(tmp).build();
        src.sendMessage(message);
        return CommandResult.success();
    }
}
