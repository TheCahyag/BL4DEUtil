package com.servegame.bl4de.BL4DEUtil.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.entity.GameModeData;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

/**
 * File: GMC.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class GMC implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof Player){
            ((Player) src).offer(Keys.GAME_MODE, GameModes.CREATIVE);
            Text t1 = Text.of(TextColors.GREEN, "Your gamemode was set to");
            Text t2 = Text.of(TextColors.YELLOW, " creative");
            Text t3 = Text.of(TextColors.GREEN, ".");
            Text[] words = {t1, t2, t3};
            src.sendMessage(Text.builder().append(words).build());
            return CommandResult.success();
        } else {
            src.sendMessage(Text.builder("This command is meant to be ran by players only!").color(TextColors.DARK_RED).build());
            return CommandResult.empty();
        }
    }
}
