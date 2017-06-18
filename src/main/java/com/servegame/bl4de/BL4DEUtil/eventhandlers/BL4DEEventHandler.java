package com.servegame.bl4de.BL4DEUtil.eventhandlers;

import com.servegame.bl4de.BL4DEUtil.BL4DEUtil;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.block.ChangeBlockEvent;

/**
 * File: BL4DEEventHandler.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class BL4DEEventHandler {
    private BL4DEUtil util;

    /**
     * Default constructor
     * @param util - {@link BL4DEUtil} - to reference logger
     */
    public BL4DEEventHandler(BL4DEUtil util){
        this.util = util;
    }

    /**
     * handleEvent will distribute events based on what type of event it is
     * @param event - {@link Event} - current event at hand
     */
    public void handleEvent(Event event){
        if (event instanceof ChangeBlockEvent.Place){
            if (!BlockPlace.handle((ChangeBlockEvent.Place) event)){
                this.util.getLogger().info("Something went wrong with the ChangeBlockEvent.Place event handler.");
                return;
            }
            return;
        }
        this.util.getLogger().info("Instance not found.");
        new Throwable().printStackTrace();
    }
}
