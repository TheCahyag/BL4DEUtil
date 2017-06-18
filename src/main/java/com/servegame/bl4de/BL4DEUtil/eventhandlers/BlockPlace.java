package com.servegame.bl4de.BL4DEUtil.eventhandlers;

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.ArrayList;
import java.util.Optional;

/**
 * File: BlockPlace.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class BlockPlace {
    private final static BlockType searchType = BlockTypes.WOOL;

    public static boolean handle(ChangeBlockEvent.Place event) {
        Optional<Player>          optionalPlayer = event.getCause().get("Owner", Player.class);
        Optional<Location<World>> optionalLocation = event.getTransactions().get(0).getFinal().getLocation();

        // Check for player
        if (!optionalPlayer.isPresent())
            return false;
        // Check for location
        if (!optionalLocation.isPresent())
            return false;

        Player          player = optionalPlayer.get();
        Location<World> location = optionalLocation.get();
        World           world = location.getExtent();

        Optional<Chunk> optionalChunk = world.getChunk(location.getChunkPosition());
        // Check for chunk
        if (!optionalChunk.isPresent())
            return false;

        Chunk chunk = optionalChunk.get();

        long startTime = System.nanoTime();

        // Populate list of chunks
        ArrayList<Chunk> chunks = new ArrayList<>();
        Direction[] directions = {  Direction.NORTHWEST, Direction.NORTH, Direction.NORTHEAST,
                                    Direction.WEST,                       Direction.EAST,
                                    Direction.SOUTHWEST, Direction.SOUTH, Direction.SOUTHEAST};
        chunks.add(chunk);
        for (Direction d :
                directions) {
            Optional<Chunk> optChunk = chunk.getNeighbor(d);
            // Check for chunk
            if (!optChunk.isPresent())
                return false;
            chunks.add(optChunk.get());
        }

        // Check each chunk for the given block
        boolean present = false;
        for (Chunk c :
                chunks) {
            if (searchChunk(searchType, c)){
                present = true;
                player.sendMessage(Text.of("Block: " + searchType.getId() + " found"));
                break;
            }
        }
        if (!present){
            event.setCancelled(true);
            player.sendMessage(Text.of("Event canceled"));
        }
        long endTime = System.nanoTime();
        player.sendMessage(Text.of("Block query time (ns/ms): " + (endTime - startTime) + "/" + (endTime - startTime)/1000000));
        return true;
    }

    private static boolean searchChunk(BlockType block, Chunk chunk){
        boolean hasBlock = false;
        Location<Chunk> chunkLocation = chunk.getLocation(chunk.getPosition());

        int blockX = chunkLocation.getBlockX() * 16, blockZ = chunkLocation.getBlockZ() * 16;
        OUTER:
        for (int k = 0; k < chunk.getWorld().getDimension().getBuildHeight(); k++) {
            for (int i = blockX; i < blockX + 16 ; i++) {
                for (int j = blockZ; j < blockZ + 16; j++) {
                    Location<World> tmp = new Location<>(chunk.getWorld(), blockX + i, k, blockZ + j);
                    BlockType tmpType = tmp.getBlock().getType();
                    if (tmpType.getId().equals(block.getId())){
                        hasBlock = true;
                        break OUTER;
                    }
                }
            }
        }
        return hasBlock;
    }
}
