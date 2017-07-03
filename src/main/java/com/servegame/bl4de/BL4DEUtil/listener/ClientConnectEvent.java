package com.servegame.bl4de.BL4DEUtil.listener;

import com.servegame.bl4de.BL4DEUtil.BL4DEUtil;
import com.servegame.bl4de.BL4DEUtil.util.FileIO.LastOnlineFileParser;
import org.spongepowered.api.event.network.ClientConnectionEvent;

import java.util.Optional;

/**
 * File: ClientConnectEvent.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class ClientConnectEvent {
    public static BL4DEUtil plugin;

    /**
     * handle logs when a player joins
     * @param event - ClientConnectionEvent
     * @return - boolean as to whether the handle was successful
     */
    public static boolean handle(ClientConnectionEvent.Login event){
        Optional<String> optionalPlayerName = event.getProfile().getName();
        if (!optionalPlayerName.isPresent()){
            plugin.getLogger().info("Couldn't get the player!");
            new Throwable().printStackTrace();
            return false;
        }
        String playerName = optionalPlayerName.get();
        LastOnlineFileParser.logPlayerJoin(playerName);
        return true;
    }
}
