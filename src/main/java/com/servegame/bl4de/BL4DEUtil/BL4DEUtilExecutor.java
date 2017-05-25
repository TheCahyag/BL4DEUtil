package com.servegame.bl4de.BL4DEUtil;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

/**
 * File: BL4DEUtilExecutor.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class BL4DEUtilExecutor implements CommandExecutor {

    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (!(src instanceof Player)){
            src.sendMessage(Text.of(TextColors.GREEN, "Hello Console!"));
            return CommandResult.success();
        } else {
            //String arg = args.getOne("id").;
            Player player = (Player) src;
            player.sendMessage(Text.of(TextColors.DARK_RED, "Hello " + player.getName()));
        }
        return CommandResult.success();
    }
}
