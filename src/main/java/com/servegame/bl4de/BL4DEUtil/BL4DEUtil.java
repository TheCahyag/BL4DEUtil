

package com.servegame.bl4de.BL4DEUtil;

import com.google.inject.Inject;
import com.servegame.bl4de.BL4DEUtil.commands.Blade.Blade;
import com.servegame.bl4de.BL4DEUtil.commands.Blade.BladeHelp;
import com.servegame.bl4de.BL4DEUtil.commands.GMC;
import com.servegame.bl4de.BL4DEUtil.commands.GMS;
import com.servegame.bl4de.BL4DEUtil.commands.Ranks;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameLoadCompleteEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

import java.util.HashMap;
import java.util.Map;

/**
 * File: BL4DEUtil.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
@Plugin(id = "bl4deutil", name = "BL4DEUtil", version = "0.0.1")
public class BL4DEUtil {

    @Inject
    private Game game;

    @Inject
    private Logger logger;

    public Logger getLogger(){
        return this.logger;
    }

    @Listener
    public void onLoad(GameLoadCompleteEvent event){
        this.logger.info("BL4DEUtil has loaded.");
    }

    @Listener
    public void onInit(GameInitializationEvent event){

        // Register /Blade
        // /Blade help
        CommandSpec bladeHelp = CommandSpec.builder()
                .description(Text.of("View commands provide with BL4DEUtil"))
                .permission("bl4de.base")
                .executor(new BladeHelp())
                .build();
        // /Blade
        CommandSpec blade = CommandSpec.builder()
                .description(Text.of("Information regarding the BL4DEUtil plugin"))
                .permission("bl4de.base")
                .child(bladeHelp, "help", "?", "commands")
                .executor(new Blade())
                .build();
        this.game.getCommandManager().register(this, blade, "blade", "bl4de");
        this.logger.info("/Blade registered");

        // Register /Ranks
        Map<String, Integer> ranksChoice = new HashMap<>();
        ranksChoice.put("labrat", 0);
        ranksChoice.put("technician", 1);
        ranksChoice.put("scientist", 2);
        CommandSpec ranks = CommandSpec.builder()
                .description(Text.of("View current ranks of the server and how they can be achieved."))
                .permission("bl4de.ranks.base")
                .arguments(
                        GenericArguments.optional(GenericArguments.choices(Text.of("rank"), ranksChoice))
                )
                .executor(new Ranks())
                .build();
        this.game.getCommandManager().register(this, ranks, "ranks", "rank");
        this.logger.info("/Ranks registered");

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
    }
}
