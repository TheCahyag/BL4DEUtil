package com.servegame.bl4de.BL4DEUtil.commands;

import com.servegame.bl4de.BL4DEUtil.BL4DEUtil;
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

        // Header of LastOnline message
        Text message = Text.of(TextColors.AQUA, "Recently Played Players: \n");

        int boundary = entries.size() >= 10 ? entries.size() - 10 : 0;
        int entriesToQuery = entries.size() >= 10 ? 10 : entries.size();
        int entriesNotQueried = entriesToQuery == 10 ? entries.size() - 10 : 0;
        if (BL4DEUtil.debug){
            src.sendMessage(Text.of("Number of entries: " + entries.size()));
        }
        for (int i = entries.size() - 1; i >= boundary; i--) {
            // Go threw 10 or less entries to print out as the most recently played players

            // Body of LastOnline message
            message = message.toBuilder()
                    .append(playerTimeToText(entries.get(i).getValue(), entries.get(i).getKey()))
                    .build();
        }
        // Footer of LastOnline message
        message = message.toBuilder()
                .append(Text.of(TextColors.AQUA, entriesToQuery + " players displayed. "
                        + entriesNotQueried + " players not displayed."))
                .build();

        src.sendMessage(message);
        return CommandResult.success();
    }

    /**
     * playerTimeToText will take the name and date of a player's login and convert
     * it to a {@link Text} object with a desired format
     * @param name - name of player
     * @param date - Join {@link Date} of the player
     * @return - {@link Text}
     */
    private Text playerTimeToText(String name, Date date){
        return Text.builder()
                .append(Text.of(TextColors.GREEN, LastOnlineFileParser.dateFormat.format(date), "    "))
                .append(Text.of(TextColors.AQUA, name, "\n"))
                .build();
    }


}

