package com.servegame.bl4de.BL4DEUtil.commands.getclw;

import com.servegame.bl4de.BL4DEUtil.BL4DEUtil;
import com.servegame.bl4de.BL4DEUtil.util.FileIO.CLWLimitFileParser;
import org.spongepowered.api.Game;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.service.sql.SqlService;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

/**
 * File: GetCLWConfirm.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class GetCLWConfirm implements CommandExecutor {
    private Game game;

    public GetCLWConfirm(BL4DEUtil util){
        this.game = util.getGame();
    }

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (!(src instanceof Player)){
            // Check if the caller is NOT a player
            src.sendMessage(Text.of("This command is meant only for players."));
            return CommandResult.empty();
        }
        // TODO MAKE SURE THERE IS ONLY 4 INVENTORIES IN MODDED MINECRAFT
        Player player = (Player) src;
        Iterator<Inventory> inventory = player.getInventory().iterator();

        Optional<ItemType> optionalType = this.game.getRegistry().getType(ItemType.class, "extrautils2:chunkloader");
        if (!optionalType.isPresent()){
            player.sendMessage(Text.of(TextColors.AQUA, "This item is not available, please contact the admins. (extrautils2:chunkloader)"));
            return CommandResult.empty();
        }
        ItemType type = optionalType.get();

        int emeraldsPresent;
        boolean hasEmeralds = false;
        OUTER:
        while (inventory.hasNext()) {
            Inventory curInventory = inventory.next();
            Iterable<Slot> slots = curInventory.slots();
            for (Slot slot :
                    slots) {
                if (slot.contains(ItemTypes.EMERALD)) {
                    emeraldsPresent = slot.getStackSize();
                    if (emeraldsPresent > 3) {
                        ItemStack remainingEmeralds = ItemStack.of(ItemTypes.EMERALD, emeraldsPresent - 3);
                        slot.set(remainingEmeralds);
                        hasEmeralds = true;
                        break OUTER;
                    } else if (emeraldsPresent == 3) {
                        hasEmeralds = true;
                        slot.clear();
                        break OUTER;
                    }
                }
            }
        }
        if (!hasEmeralds) {
            player.sendMessage(Text.of(TextColors.DARK_RED,
                    "You do not have enough emeralds to complete this transaction. " +
                            "Make sure all emeralds are in the same stack"));
        } else {
            // The player has 3 emeralds
            Optional<Map<String, Integer>> refOptional = CLWLimitFileParser.parseFile();
            if (!refOptional.isPresent()){
                player.sendMessage(Text.of(TextColors.DARK_RED, "An error has occurred. Please report this to the admins."));
                new Throwable().printStackTrace();
                return CommandResult.empty();
            }
            int playersChunkLoaders = CLWLimitFileParser.getPlayersChunkLoaders(player.getName());
            if (playersChunkLoaders >= 5){
                // Player has hit the limit
                player.sendMessage(Text.of(TextColors.DARK_RED, "Unable to purchase chunk loader: The limit of five chunk loaders was exceeded "));
            } else if (playersChunkLoaders == -1){
                // An error has occurred trace back to CLWLimitFileParser.getPlayersChunkLoaders()
                player.sendMessage(Text.of(TextColors.DARK_RED, "An error has occurred. Please report this to the admins."));
            } else {
                // Preform transaction
                ItemStack item = ItemStack.of(type, 1);
                player.getInventory().offer(item);
            }
        }
        return CommandResult.success();
    }
}
