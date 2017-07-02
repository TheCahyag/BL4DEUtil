package com.servegame.bl4de.BL4DEUtil.commands;

import com.servegame.bl4de.BL4DEUtil.util.FileIO.LastOnlineFileParser;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.util.*;

/**
 * File: LastOnline.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class LastOnline implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Optional<Map<Date, String>> optionalPlayerData = LastOnlineFileParser.getRecentPlayerLogins();
        if (!optionalPlayerData.isPresent()){
            src.sendMessage(Text.of(TextColors.AQUA, "No player entries were found. (It probably couldn't access the file)"));
            return CommandResult.empty();
        }
        Map<Date, String> playerData = optionalPlayerData.get();
        ArrayList<Map.Entry<Date, String>> entries = new ArrayList<>(playerData.entrySet());
        Text message = Text.of();
        int size = entries.size() >= 10 ? 10 : entries.size();
        for (int i = 0; i < size; i++) {
            // Go threw 10 or less entries to print out as the most recently played players
            message.toBuilder()
                    .append(Text.of(TextColors.AQUA, entries.get(i).getValue(), " "))
                    .append(Text.of(TextColors.GREEN, entries.get(i).getKey().toString(), "\n"))
                    .build();
        }
        src.sendMessage(message);
        return CommandResult.success();
    }


}

