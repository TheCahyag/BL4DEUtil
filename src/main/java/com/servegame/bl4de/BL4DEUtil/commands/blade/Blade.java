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

/**
 * File: blade.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class Blade implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        /*
            ----------------------------------------------------
            BL4DEUtil
            Author(s): TheCahyag
            Commands: /blade commands
            ----------------------------------------------------
         */
        Text message = Text.builder()
                .append(Text.of(TextColors.GRAY, "----------------------------------------------------\n",
                        TextColors.DARK_RED, "BL4DE",
                        TextColors.DARK_GRAY, "Util\n",
                        TextColors.BLUE, "Author(s)",
                        TextColors.WHITE, ": ",
                        TextColors.GOLD, "TheCahyag\n",
                        TextColors.GREEN, "Commands",
                        TextColors.WHITE, ": /"))
                .append(Text.builder()
                        .append(Text.of(TextColors.GREEN, TextStyles.UNDERLINE, "blade commands"))
                        .onClick(TextActions.runCommand("/blade commands"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                        .build())
                .append(Text.of(TextColors.GRAY, "----------------------------------------------------"))
                .build();
        src.sendMessage(message);
        return CommandResult.success();
    }
}
