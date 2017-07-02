package com.servegame.bl4de.BL4DEUtil.listener;

import com.servegame.bl4de.BL4DEUtil.BL4DEUtil;
import com.servegame.bl4de.BL4DEUtil.util.FileIO.LastOnlineFileParser;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.network.ClientConnectionEvent;

import java.util.Optional;

/**
 * File: ClientConnectEvent.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class ClientConnectEvent {
    public static BL4DEUtil plugin;

    /**
     * handle logs when a player joins
     * @param event - ClientConnectionEvent
     * @return - boolean as to whether the handle was successful
     */
    public static boolean handle(ClientConnectionEvent event){
        Optional<Player> optionalPlayer = event.getCause().get("Owner", Player.class);
        if (!optionalPlayer.isPresent()){
            plugin.getLogger().info("Couldn't get the player!");
            return false;
        }
        Player player = optionalPlayer.get();
        LastOnlineFileParser.logPlayerJoin(player.getName());
        return true;
    }
}
