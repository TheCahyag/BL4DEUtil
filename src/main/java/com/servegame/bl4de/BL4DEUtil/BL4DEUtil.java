package com.servegame.bl4de.BL4DEUtil;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = "bl4deutil", name = "BL4DEUtil", version = "0.0.1")
public class BL4DEUtil {

    @Inject
    Game game;

    @Inject
    Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event){
        logger.info("Plugin has loaded!");
    }

}
