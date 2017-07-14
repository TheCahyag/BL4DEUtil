package com.servegame.bl4de.BL4DEUtil.modules.ranks.commands;

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
 * File: ranks.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class Ranks implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        /*
            ----------------------------------------------------
            Rank: [LabRat]
               /ranks labrat
            Rank: [Technician]
               /ranks technician
            Rank: [Scientist]
               /ranks scientist
            ----------------------------------------------------
         */
        Text message = Text.builder()
                .append(Text.of(TextColors.GRAY, "----------------------------------------------------\n",
                        TextColors.GREEN, "Rank",
                        TextColors.WHITE, ": [",
                        TextColors.AQUA, "LabRat",
                        TextColors.WHITE, "]\n",
                        TextColors.WHITE, "   /"))
                .append(Text.builder()
                        .append(Text.of(TextColors.GREEN, TextStyles.UNDERLINE, "ranks labrat\n"))
                        .onClick(TextActions.runCommand("/ranks labrat"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command")))
                        .build())
                .append(Text.of(TextColors.GREEN, "Rank",
                        TextColors.WHITE, ": [",
                        TextColors.GOLD, "Technician",
                        TextColors.WHITE, "]\n",
                        TextColors.WHITE, "   /"))
                .append(Text.builder()
                        .append(Text.of(TextColors.GREEN, TextStyles.UNDERLINE, "ranks technician\n"))
                        .onClick(TextActions.runCommand("/ranks technician"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command")))
                        .build())
                .append(Text.of(TextColors.GREEN, "Rank",
                        TextColors.WHITE, ": [",
                        TextColors.DARK_BLUE, "Scientist",
                        TextColors.WHITE, "]\n",
                        TextColors.WHITE, "   /"))
                .append(Text.builder()
                        .append(Text.of(TextColors.GREEN, TextStyles.UNDERLINE, "ranks scientist\n"))
                        .onClick(TextActions.runCommand("/ranks scientist"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command")))
                        .build())
                .append(Text.of(TextColors.GRAY, "----------------------------------------------------"))
                .build();
        src.sendMessage(message);
        return CommandResult.success();
    }
}
