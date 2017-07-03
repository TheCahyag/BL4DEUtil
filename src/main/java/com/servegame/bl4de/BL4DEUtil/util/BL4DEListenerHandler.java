package com.servegame.bl4de.BL4DEUtil.util;

import com.servegame.bl4de.BL4DEUtil.BL4DEUtil;
import com.servegame.bl4de.BL4DEUtil.listener.ChangeBlockEventPlaceEvent;
import com.servegame.bl4de.BL4DEUtil.listener.ClientConnectEvent;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;

/**
 * File: BL4DEListenerHandler.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class BL4DEListenerHandler {
    private BL4DEUtil util;

    /**
     * Default constructor
     * @param util - {@link BL4DEUtil} - to reference logger
     */
    public BL4DEListenerHandler(BL4DEUtil util){
        this.util = util;
    }

    /**
     * handleEvent will distribute events based on what type of event it is
     * @param event - {@link Event} - current event at hand
     */
    public void handleEvent(Event event){
        if (event instanceof ChangeBlockEvent.Place){
            if (!ChangeBlockEventPlaceEvent.handle((ChangeBlockEvent.Place) event)){
                this.util.getLogger().info("Something went wrong with the ChangeBlockEvent.Place event handler.");
            }
            return;
        } else if (event instanceof ClientConnectionEvent.Login){
            ClientConnectEvent.plugin = this.util;
            if (!ClientConnectEvent.handle((ClientConnectionEvent.Login) event)){
                this.util.getLogger().info("Something went wrong with the ClientConnectionEvent event handler.");
            }
            return;
        }
        this.util.getLogger().info("Instance not found.");
        new Throwable().printStackTrace();
    }
}
