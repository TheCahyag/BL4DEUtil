package com.servegame.bl4de.BL4DEUtil.modules.lastonline.commands;

import com.servegame.bl4de.BL4DEUtil.BL4DEUtil;
import com.servegame.bl4de.BL4DEUtil.modules.lastonline.fileparser.LastOnlineFileParser;
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
 * LastOnline is a command that when executed will gather and store player's
 * join dates into a TreeMap and print out the (at most) 10 most recent
 * players who have been on the server.
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class LastOnline implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Optional<String> playerNameOptional = args.getOne("player");

        // Woah Intellij, I like this
        // Check if a player's name was specified
        return playerNameOptional.map(player -> displayPlayer(src, player)).orElseGet(() -> displayPlayers(src));
    }

    /**
     * displayPlayers will display the 10 most recent players and the associated times of their last presence
     * @param src - command source
     */
    private CommandResult displayPlayers(CommandSource src){
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
            // Go through 10 or less entries to print out as the most recently played players

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
     * displayPlayer will display the time a given player was online
     * @param src - command source
     * @param name - player to display
     */
    private CommandResult displayPlayer(CommandSource src, String name){
        Optional<Map<Date, String>> optionalPlayerData = LastOnlineFileParser.getRecentPlayerLogins();
        if (!optionalPlayerData.isPresent()){
            src.sendMessage(Text.of(TextColors.AQUA, "No player entries were found. (It probably couldn't access the file)"));
            return CommandResult.empty();
        }
        Map<Date, String> playerData = optionalPlayerData.get();
        Date possibleDate = null;
        for (Map.Entry<Date, String> entry :
                playerData.entrySet()) {
            // Go through entries and find the player we are looking for,
            // then set the date they were last on
            if (entry.getValue().equals(name)){
                possibleDate = entry.getKey();
            }
        }
        if (possibleDate == null){
            // Null check on possibleDate, if the entry wasn't found the date defaults as null
            src.sendMessage(Text.of(TextColors.DARK_RED, "The player '" + name + "' was not found, or doesn't have an entry."));
            return CommandResult.success();
        }
        String possession = "'s";
        if (name.endsWith("s") || name.endsWith("S")){
            possession = "'";
        }
        src.sendMessage(Text.of(TextColors.AQUA, name + possession + " last login timestamp was: ", TextColors.GREEN, timeToText(possibleDate)));
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
                .append(Text.of(TextColors.GREEN, timeToText(date), "    "))
                .append(Text.of(TextColors.AQUA, name, "\n"))
                .build();
    }

    /**
     * timeToText will take a date and convert it to a {@link Text} object
     * @param date {@link Date}
     * @return {@link Text}
     */
    private Text timeToText(Date date){
        return Text.builder(LastOnlineFileParser.dateFormat.format(date)).build();
    }
}

