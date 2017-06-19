package com.servegame.bl4de.BL4DEUtil.eventhandlers;

import com.servegame.bl4de.BL4DEUtil.BL4DEUtil;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.ArrayList;
import java.util.Optional;

/**
 * File: BlockPlace.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class BlockPlace {
    private final static String searchFor = "extrautils2:chunkloader";
    private static ArrayList<String> activateOnTheseBlocks = new ArrayList<>();

    /**
     * handle TODO
     * @param event {@link org.spongepowered.api.event.Event}
     * @return - boolean - whether or not the event *could* be handled
     */
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

        if (BL4DEUtil.debug){
            player.sendMessage(Text.of(location.getBlockType().getId()));
        }

        BlockPlace.activateOnTheseBlocks.add("ae2stuff:Encoder");
        BlockPlace.activateOnTheseBlocks.add("ae2stuff:Grower");
        BlockPlace.activateOnTheseBlocks.add("ae2stuff:Inscriber");
        BlockPlace.activateOnTheseBlocks.add("ae2stuff:Wireless");

        // Check what block was placed
        if (!activateOnTheseBlocks.contains(location.getBlockType().getId())){
            return true;
        }

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
            if (searchChunk(c)){
                present = true;
                if (BL4DEUtil.debug){
                    player.sendMessage(Text.of("Block: " + searchFor + " found"));
                }
                break;
            }
        }
        if (!present){
            event.setCancelled(true);
            player.sendMessage(Text.of(TextColors.AQUA, "Use of this block is only allowed when in the radius of a chunk loading ward. /getclw"));
        }
        long endTime = System.nanoTime();
        if (BL4DEUtil.debug){
            player.sendMessage(Text.of("Block query time (ns/ms): " + (endTime - startTime) + "/" + (endTime - startTime)/1000000));
        }
        return true;
    }

    /**
     * searchChunk searches the 3d space of a chunk in search of {@link BlockPlace#searchFor}
     * @param chunk - the given {@link Chunk}
     * @return - boolean - whether or not the block was found in the given chunk
     */
    private static boolean searchChunk(Chunk chunk){
        boolean hasBlock = false;
        Location<Chunk> chunkLocation = chunk.getLocation(chunk.getPosition());
        int blockX = chunkLocation.getBlockX() * 16, blockZ = chunkLocation.getBlockZ() * 16;
        OUTER:
        // Iterate through a 3-dimensional area and look at each specific block
        for (int k = 0; k < chunk.getWorld().getDimension().getBuildHeight(); k++) {
            for (int i = 0; i < 16 ; i++) {
                for (int j = 0; j < 16; j++) {
                    Location<World> tmp = new Location<>(chunk.getWorld(), blockX + i, k, blockZ + j);
                    BlockType tmpType = tmp.getBlock().getType();
                    if (tmpType.getId().equals(searchFor)){
                        hasBlock = true;
                        break OUTER;
                    }
                }
            }
        }
        return hasBlock;
    }

    /**
     * just used for debug stuff, sometimes...
     * @param x x
     * @param y y
     * @param z z
     */
    private static void printCoords(int x, int y, int z){
        System.out.println("X: " + x + " Y: " + y + " Z: " + z);
    }
}
