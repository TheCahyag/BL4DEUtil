package com.servegame.bl4de.BL4DEUtil.modules.gamemode.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

/**
 * File: GMS.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class GMS implements CommandExecutor {


    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof Player){
            ((Player) src).offer(Keys.GAME_MODE, GameModes.SURVIVAL);
            Text message = Text.builder()
                    .append(Text.of(TextColors.GREEN, "Your gamemode was set to",
                            TextColors.YELLOW, " survival",
                            TextColors.GREEN, "."))
                    .build();
            src.sendMessage(message);
            return CommandResult.success();
        } else {
            src.sendMessage(Text.of(TextColors.DARK_RED, "This command is meant to be ran by players only!"));
            return CommandResult.empty();
        }
    }
}
