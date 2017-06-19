

package com.servegame.bl4de.BL4DEUtil;

import com.google.inject.Inject;
import com.servegame.bl4de.BL4DEUtil.commands.blade.Blade;
import com.servegame.bl4de.BL4DEUtil.commands.blade.BladeHelp;
import com.servegame.bl4de.BL4DEUtil.commands.blade.BladeToggleDebug;
import com.servegame.bl4de.BL4DEUtil.commands.GMC;
import com.servegame.bl4de.BL4DEUtil.commands.GMS;
import com.servegame.bl4de.BL4DEUtil.commands.ranks.LabRat;
import com.servegame.bl4de.BL4DEUtil.commands.ranks.Ranks;
import com.servegame.bl4de.BL4DEUtil.commands.ranks.Scientist;
import com.servegame.bl4de.BL4DEUtil.commands.ranks.Technician;
import com.servegame.bl4de.BL4DEUtil.eventhandlers.BL4DEEventHandler;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameLoadCompleteEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

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
    public static boolean debug = false;

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
        /* Command Register START */
        // Register /blade
        // /blade debug
        CommandSpec bladeDebug = CommandSpec.builder()
                .description(Text.of("Toggles the debug mode for BL4DEUtil"))
                .permission("bl4de.debug.base")
                .executor(new BladeToggleDebug())
                .build();
        // /blade help
        CommandSpec bladeHelp = CommandSpec.builder()
                .description(Text.of("View commands provide with BL4DEUtil"))
                .permission("bl4de.base")
                .executor(new BladeHelp())
                .build();
        // /blade
        CommandSpec blade = CommandSpec.builder()
                .description(Text.of("Information regarding the BL4DEUtil plugin"))
                .permission("bl4de.base")
                .child(bladeHelp, "help", "?", "commands")
                .child(bladeDebug, "debug", "d")
                .executor(new Blade())
                .build();
        this.game.getCommandManager().register(this, blade, "blade", "bl4de");
        this.logger.info("/blade registered");

        // Register /ranks
        // /ranks LabRat
        CommandSpec labRat = CommandSpec.builder()
                .description(Text.of("Show information about the LabRat rank"))
                .permission("bl4de.ranks.base")
                .executor(new LabRat())
                .build();

        // /ranks Technician
        CommandSpec technician = CommandSpec.builder()
                .description(Text.of("Show information about the Technician rank"))
                .permission("bl4de.ranks.base")
                .executor(new Technician())
                .build();

        // /ranks Scientist
        CommandSpec scientist = CommandSpec.builder()
                .description(Text.of("Show information about the Scientist rank"))
                .permission("bl4de.ranks.base")
                .executor(new Scientist())
                .build();
        // /ranks
        CommandSpec ranks = CommandSpec.builder()
                .description(Text.of("View current ranks of the server and how they can be achieved."))
                .permission("bl4de.ranks.base")
                .child(labRat, "labrat")
                .child(technician, "technician")
                .child(scientist, "scientist")
                .executor(new Ranks())
                .build();
        this.game.getCommandManager().register(this, ranks, "ranks", "rank");
        this.logger.info("/ranks registered");

        // Register /GMC
        CommandSpec gmc = CommandSpec.builder()
                .description(Text.of("Sets the gamemode of the player to creative."))
                .permission("bl4de.gamemode.creative")
                .executor(new GMC())
                .build();
        this.game.getCommandManager().register(this, gmc, "gmc");
        this.logger.info("/GMC registered");

        // Register /GMS
        CommandSpec gms = CommandSpec.builder()
                .description(Text.of("Sets the gamemode of the player to survival."))
                .permission("bl4de.gamemode.survival")
                .executor(new GMS())
                .build();
        this.game.getCommandManager().register(this, gms, "gms");
        this.logger.info("/GMS registered");
        /* Command Register END */

        // EventHandler
        this.eventHandler = new BL4DEEventHandler(this);
    }

    @Listener
    public void onChangeBlockPlaceEvent(ChangeBlockEvent.Place event, @Root Player player){
        this.eventHandler.handleEvent(event);
    }
}
