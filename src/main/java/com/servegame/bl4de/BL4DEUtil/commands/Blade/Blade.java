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
        Text message = Text.of(
                TextColors.GRAY + "----------------------------------------------------\n" +
                        TextColors.DARK_RED + "BL4DE" + TextColors.DARK_BLUE + "Util\n" +
                        TextColors.BLUE + "@author" + TextColors.WHITE + ": " + TextColors.GOLD + "TheCahyag\n" +
                        TextColors.GREEN + "Commands" + TextColors.WHITE + ": /" + TextColors.GREEN + "Blade commands\n" +
                        TextColors.GRAY + "----------------------------------------------------\n"
        );
        src.sendMessage(message);
        return CommandResult.success();
    }
}
