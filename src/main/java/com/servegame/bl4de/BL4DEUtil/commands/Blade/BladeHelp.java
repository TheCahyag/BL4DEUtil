package com.servegame.bl4de.BL4DEUtil.commands.Blade;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

/**
 * File: BladeHelp.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class BladeHelp implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Text message = Text.of(
                TextColors.GREEN + "Commands" + TextColors.WHITE + ":\n" +
                        TextColors.WHITE + "/" + TextColors.GREEN + "Blade [help]\n" +
                        TextColors.WHITE + "/" + TextColors.GREEN + "Ranks <labrat|technician|scientist>\n" +
                        TextColors.WHITE + "/" + TextColors.GREEN + "GMS\n" +
                        TextColors.WHITE + "/" + TextColors.GREEN + "GMC\n"
        );
        src.sendMessage(message);
        return CommandResult.success();
    }
}
