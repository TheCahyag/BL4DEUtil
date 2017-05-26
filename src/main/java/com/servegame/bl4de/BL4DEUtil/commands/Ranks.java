package com.servegame.bl4de.BL4DEUtil.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

/**
 * File: Ranks.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class Ranks implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (args.<String>getOne("rank").isPresent()){
            String rank = args.<String>getOne("rank").get();
            Text message;
            switch (rank){
                case "labrat":
                    message = Text.of(
                            TextColors.WHITE + "&4[" + TextColors.AQUA + "LabRat" + TextColors.WHITE + "]\n"
                    );
                    break;
                case "technician":
                    message = Text.of(
                            TextColors.WHITE + "[" + TextColors.GOLD + "Technician" + TextColors.WHITE + "]\n"
                    );
                    break;
                case "scientist":
                    message = Text.of(
                            TextColors.WHITE + "[" + TextColors.GREEN + "Scientist" + TextColors.WHITE + "]\n"
                    );
                    break;
                default:
                    message = Text.of(TextColors.RED + "Usage: /Ranks <labrat|technician|scientist>\n");
                    break;
            }
            src.sendMessage(message);
        } else {
            Text message = Text.of(TextColors.RED + "Usage: /Ranks <labrat|technician|scientist>\n");
            src.sendMessage(message);
        }
        return CommandResult.success();
    }
}
