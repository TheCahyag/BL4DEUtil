package com.servegame.bl4de.BL4DEUtil.modules.getclw.fileparser;

import com.servegame.bl4de.BL4DEUtil.BL4DEUtil;
import org.slf4j.Logger;

import java.io.*;
import java.util.*;

/**
 * File: CLWLimitFileParser.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 * This file parser is meant to keep track of how many chunk loading wards (CLW) a player has accumulated and
 * will stop the player from getting more than alotted the max in this case being five.
 */
public class CLWLimitFileParser {
    private static BL4DEUtil util;
    private static Logger logger;

    public CLWLimitFileParser(BL4DEUtil plugin){
        util = plugin;
        logger = plugin.getLogger();
    }

    /**
     * parseFile will parse clw_count.dat. Format: PLAYER_NAME|INTEGER
     * @return - Map containing 1 entry per person
     */
    public static Optional<Map<String, Integer>> parseFile(){
        File file = new File(util.getCLWCounterDataDir());

        Map<String, Integer> clwCount = new HashMap<>();
        synchronized (CLWLimitFileParser.class) {
            try (Scanner in = new Scanner(file)) {
                while (in.hasNextLine()) {
                    // Line format: PLAYER_NAME|INTEGER
                    String[] tokens = in.nextLine().split("\\|");
                    clwCount.put(tokens[0], Integer.parseInt(tokens[1]));
                }
                in.close();
            } catch (FileNotFoundException e) {
                logger.info("Encountered an FileNotFoundException while parsing clw_count.dat (most likely).");
                e.printStackTrace();
                return Optional.empty();
            }
            return Optional.of(clwCount);
        }
    }

    /**
     * logCLWPurchase gets a map containing data makes the necessary changes and then calls the writeChanges method
     * @param name - name of player
     */
    public static void logCLWPurchase(String name){
        Optional<Map<String, Integer>> mapOptional = parseFile();

        Map<String, Integer> data;
        if (!mapOptional.isPresent()){
            logger.info("No player entries were found. (It probably couldn't access the file)");
            new Throwable().printStackTrace();
            return;
        }
        data = mapOptional.get();
        OUTER:
        if (data.containsKey(name)){
            for (Map.Entry<String, Integer> entry :
                    data.entrySet()) {
                // Iterate through entry set looking for the given name
                if (entry.getKey().equals(name)){
                    data.remove(entry.getKey());
                    data.put(name, entry.getValue() + 1);
                    break OUTER;
                }
            }
        } else {
            data.put(name, 1);
        }
        writeChanges(data);
    }

    /**
     * getPlayersChunkLoaders returns the number of chunk loaders the player has bought
     * @param name - Players name
     * @return the number of chunk loaders a player has bought, or -1 if an error occurred
     */
    public static int getPlayersChunkLoaders(String name){
        Optional<Map<String, Integer>> mapOptional = parseFile();
        if (!mapOptional.isPresent()){
            logger.info("No player entries were found. (It probably couldn't access the file)");
            new Throwable().printStackTrace();
            return -1;
        }
        Map<String, Integer> data = mapOptional.get();
        return data.getOrDefault(name, 0);
    }

    /**
     * writeChanges writes a map to a file (overriding the contents)
     * @param map - map to write
     */
    private static void writeChanges(Map<String, Integer> map){
        synchronized (CLWLimitFileParser.class) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(util.getCLWCounterDataDir()))) {
                for (Map.Entry<String, Integer> entry :
                        map.entrySet()) {
                    String line = entry.getKey() + "|" + entry.getValue() + "\n";
                    bw.write(line);
                }
                bw.close();
            } catch (IOException e) {
                logger.info("Ran into a problem when trying to write to the data file.");
                e.printStackTrace();
            }
        }
    }
}
