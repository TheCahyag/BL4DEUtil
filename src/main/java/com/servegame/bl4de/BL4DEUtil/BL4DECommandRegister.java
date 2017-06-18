package com.servegame.bl4de.BL4DEUtil;

import com.servegame.bl4de.BL4DEUtil.commands.Blade.Blade;
import com.servegame.bl4de.BL4DEUtil.commands.Blade.BladeHelp;
import com.servegame.bl4de.BL4DEUtil.commands.GMC;
import com.servegame.bl4de.BL4DEUtil.commands.GMS;
import com.servegame.bl4de.BL4DEUtil.commands.Ranks.LabRat;
import com.servegame.bl4de.BL4DEUtil.commands.Ranks.Ranks;
import com.servegame.bl4de.BL4DEUtil.commands.Ranks.Scientist;
import com.servegame.bl4de.BL4DEUtil.commands.Ranks.Technician;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

/**
 * File: BL4DECommandRegister.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class BL4DECommandRegister {
    private Game game;
    private BL4DEUtil util;
    private Logger logger = this.util.getLogger();

    /**
     * Default constructor
     * @param game {@link Game}
     * @param util {@link BL4DEUtil}
     */
    public BL4DECommandRegister(Game game, BL4DEUtil util){
        this.game = game;
        this.util = util;
    }

    /**
     * registerCommands registers all commands with the Sponge commandManager
     */
    public void registerCommands(){
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
        // /Ranks LabRat
        CommandSpec labRat = CommandSpec.builder()
                .description(Text.of("Show information about the LabRat rank"))
                .permission("bl4de.ranks.base")
                .executor(new LabRat())
                .build();

        // /Ranks Technician
        CommandSpec technician = CommandSpec.builder()
                .description(Text.of("Show information about the Technician rank"))
                .permission("bl4de.ranks.base")
                .executor(new Technician())
                .build();

        // /Ranks Scientist
        CommandSpec scientist = CommandSpec.builder()
                .description(Text.of("Show information about the Scientist rank"))
                .permission("bl4de.ranks.base")
                .executor(new Scientist())
                .build();
        // /Ranks
        CommandSpec ranks = CommandSpec.builder()
                .description(Text.of("View current ranks of the server and how they can be achieved."))
                .permission("bl4de.ranks.base")
                .child(labRat, "labrat")
                .child(technician, "technician")
                .child(scientist, "scientist")
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
