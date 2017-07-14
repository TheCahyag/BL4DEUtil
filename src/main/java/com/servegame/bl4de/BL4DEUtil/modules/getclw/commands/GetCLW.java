package com.servegame.bl4de.BL4DEUtil.modules.getclw.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

/**
 * File: GetCLW.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class GetCLW implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (!(src instanceof Player)){
            // Check if the caller is NOT a player
            src.sendMessage(Text.of("This command is meant only for players."));
            return CommandResult.empty();
        }
        /*
            In exchange for 3 emeralds, you will receive one Chunk
            Loading Ward (From ExtraUtils2) /GetCLW Confirm
         */
        Text message = Text.builder()
                .append(Text.of(TextColors.AQUA, "In exchange for ",
                        TextColors.DARK_BLUE, "3 ",
                        TextColors.GREEN, "emeralds, ",
                        TextColors.AQUA, "you will receive one Chunk Loading Ward (From ExtraUtils2) "))
                .append(Text.builder()
                        .append(Text.of(TextColors.AQUA, TextStyles.UNDERLINE, "/GetCLW Confirm"))
                        .onClick(TextActions.runCommand("/GetCLW c"))
                        .onHover(TextActions.showText(Text.of("Click here to suggest this command.")))
                        .build())
                .build();
        src.sendMessage(message);
        return CommandResult.success();
    }
}
