

package com.servegame.bl4de.BL4DEUtil;

import com.google.inject.Inject;
import com.servegame.bl4de.BL4DEUtil.eventhandlers.BL4DEEventHandler;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameLoadCompleteEvent;
import org.spongepowered.api.plugin.Plugin;

import java.nio.file.Path;

/**
 * File: BL4DEUtil.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
@Plugin(id = "bl4deutil", name = "BL4DEUtil", version = "0.0.1",
    authors = {"TheCahyag"},
    url = "https://github.com/TheCahyag/BL4DEUtil")
public class BL4DEUtil {

    private BL4DEEventHandler eventHandler;

    @Inject private Game game;
    @Inject private Logger logger;

    @Inject
    @DefaultConfig(sharedRoot = true)
    private Path defaultConfig;

    @Inject
    @DefaultConfig(sharedRoot = true)
    private ConfigurationLoader<CommentedConfigurationNode> configManager;

    @Inject
    @DefaultConfig(sharedRoot = true)
    private Path privateConfigDir;

    public Logger getLogger(){
        return this.logger;
    }

    @Listener
    public void onLoad(GameLoadCompleteEvent event){
        this.logger.info("BL4DEUtil has loaded.");
    }

    @Listener
    public void onInit(GameInitializationEvent event){
        // Register Commands
        BL4DECommandRegister commandRegister = new BL4DECommandRegister(this.game, this);
        commandRegister.registerCommands();

        // EventHandler
        this.eventHandler = new BL4DEEventHandler(this);
    }

    @Listener
    public void onChangeBlockPlaceEvent(ChangeBlockEvent.Place event){
        this.eventHandler.handleEvent(event);
    }
}
