package com.servegame.bl4de.BL4DEUtil.commands.blade;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import javax.print.attribute.TextSyntax;

/**
 * File: BladeHelp.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class BladeHelp implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        /*
            Commands: ([] = optional, <> = required)
            /blade [help|debug]
            /ranks [labrat|technician|scientist]
            /GMS
            /GMC
            /GetCLW [Confirm]
            /LastOnline
         */
        Text message = Text.builder()
                .append(Text.of(TextColors.GREEN, "Commands",
                        TextColors.WHITE, ": ([] = optional, <> = required)\n",
                        TextColors.WHITE, "/"))
                .append(Text.builder()
                        .append(Text.of(TextColors.GREEN, TextStyles.UNDERLINE, "blade"))
                        .onClick(TextActions.runCommand("/blade"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                        .build())
                .append(Text.of(TextColors.GREEN, " ["))
                .append(Text.builder()
                        .append(Text.of(TextColors.GREEN, TextStyles.UNDERLINE, "help"))
                        .onClick(TextActions.runCommand("/blade ?"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                        .build())
                .append(Text.of(TextColors.GREEN, "|"))
                .append(Text.builder()
                        .append(Text.of(TextColors.GREEN, TextStyles.UNDERLINE, "debug"))
                        .onClick(TextActions.runCommand("/blade debug"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                        .build())
                .append(Text.of(TextColors.GREEN, "]\n",
                        TextColors.WHITE, "/"))
                .append(Text.builder()
                        .append(Text.of(TextColors.GREEN, TextStyles.UNDERLINE, "ranks"))
                        .onClick(TextActions.runCommand("/ranks"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                        .build())
                .append(Text.of(TextColors.GREEN, " ["))
                .append(Text.builder()
                        .append(Text.of(TextColors.GREEN, TextStyles.UNDERLINE, "labrat"))
                        .onClick(TextActions.runCommand("/ranks labrat"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                        .build())
                .append(Text.of(TextColors.GREEN, "|"))
                .append(Text.builder()
                        .append(Text.of(TextColors.GREEN, TextStyles.UNDERLINE, "technician"))
                        .onClick(TextActions.runCommand("/ranks technician"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                        .build())
                .append(Text.of(TextColors.GREEN, "|"))
                .append(Text.builder()
                        .append(Text.of(TextColors.GREEN, TextStyles.UNDERLINE, "scientist"))
                        .onClick(TextActions.runCommand("/ranks scientist"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                        .build())
                .append(Text.of(TextColors.GREEN, "]\n",
                        TextColors.WHITE, "/"))
                .append(Text.builder()
                        .append(Text.of(TextColors.GREEN, TextStyles.UNDERLINE, "GMS\n"))
                        .onClick(TextActions.runCommand("/GMS"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                        .build())
                .append(Text.of(TextColors.WHITE, "/"))
                .append(Text.builder()
                        .append(Text.of(TextColors.GREEN, TextStyles.UNDERLINE, "GMC\n"))
                        .onClick(TextActions.runCommand("/GMC"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                        .build())
                .append(Text.of(TextColors.WHITE, "/"))
                .append(Text.builder()
                        .append(Text.of(TextColors.GREEN, TextStyles.UNDERLINE, "GetCLW"))
                        .onClick(TextActions.runCommand("/GetCLW"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                        .build())
                .append(Text.of(TextColors.GREEN, " ["))
                .append(Text.builder()
                        .append(Text.of(TextColors.GREEN, TextStyles.UNDERLINE, "Confirm"))
                        .onClick(TextActions.runCommand("/GetCLW C"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                        .build())
                .append(Text.of(TextColors.GREEN, "]\n", TextColors.WHITE, "/"))
                .append(Text.builder()
                        .append(Text.of(TextColors.GREEN, TextStyles.UNDERLINE, "LastOnline"))
                        .onClick(TextActions.runCommand("/LastOnline"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                        .build())
                .build();
        src.sendMessage(message);
        return CommandResult.success();
    }
}
