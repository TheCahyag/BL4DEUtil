package com.servegame.bl4de.BL4DEUtil.commands.Blade;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

/**
 * File: BladeHelp.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class BladeHelp implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Text t1 = Text.of(TextColors.GREEN, "Commands");
        Text t2 = Text.of(TextColors.WHITE, ": ([] = optional, <> = required)\n");
        Text t3 = Text.of(TextColors.WHITE, "/");
        Text t4 = Text.of(TextColors.GREEN, "Blade [help|debug]\n");
        Text t5 = Text.of(TextColors.WHITE, "/");
        Text t6 = Text.builder("Ranks")
                .color(TextColors.GREEN)
                .style(TextStyles.UNDERLINE)
                .onClick(TextActions.runCommand("/ranks"))
                .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                .append(Text.of(TextColors.GREEN, TextStyles.NONE, " ["))
                .build();
        Text t7 = Text.builder("labrat")
                .color(TextColors.GREEN)
                .style(TextStyles.UNDERLINE)
                .onClick(TextActions.runCommand("/ranks labrat"))
                .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                .append(Text.of(TextColors.GREEN, TextStyles.NONE, "|"))
                .build();
        Text t8 = Text.builder("technician")
                .color(TextColors.GREEN)
                .style(TextStyles.UNDERLINE)
                .onClick(TextActions.runCommand("/ranks technician"))
                .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                .append(Text.of(TextColors.GREEN, TextStyles.NONE, "|"))
                .build();
        Text t9 = Text.builder("scientist")
                .color(TextColors.GREEN)
                .style(TextStyles.UNDERLINE)
                .onClick(TextActions.runCommand("/ranks scientist"))
                .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                .append(Text.of(TextColors.GREEN, TextStyles.NONE, "]\n"))
                .build();
        Text t10 = Text.of(TextColors.WHITE, "/");
        Text t11 = Text.of(TextColors.GREEN, "GMS\n");
        Text t12 = Text.of(TextColors.WHITE, "/");
        Text t13 = Text.of(TextColors.GREEN, "GMC");
        Text[] tmp = {t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13};
        Text message = Text.builder().append(tmp).build();
        src.sendMessage(message);
        return CommandResult.success();
    }
}
