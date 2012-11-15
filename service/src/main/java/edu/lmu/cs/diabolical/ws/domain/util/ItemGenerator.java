package edu.lmu.cs.diabolical.ws.domain.util;

import java.util.Random;

import edu.lmu.cs.diabolical.ws.domain.Item;
import edu.lmu.cs.diabolical.ws.domain.ItemTemplate;

/**
 * The ItemGenerator takes an ItemTemplate and returns a randomized Item.
 */
public class ItemGenerator {
    private static Random generator = new Random();

    /**
     * Generates a fully random item from the item template provided with no
     * weighting
     * @param it Item Template from which to construct the new Item
     * @return Random Item generated from provided Item Template
     */
    public static Item generateRandomItem(ItemTemplate it) {
        return new Item(null, it.getName(), it.getSlot(),
                getRandomDoubleFromRange(it.getMinMindamage(), it.getMaxMindamage()),
                getRandomDoubleFromRange(it.getMinMaxdamage(), it.getMaxMaxdamage()),
                getRandomDoubleFromRange(it.getMinCritchance(), it.getMaxCritchance()),
                getRandomIntegerFromRange(it.getMinAtkspeed(), it.getMaxAtkspeed()),
                getRandomDoubleFromRange(it.getMinDefense(), it.getMaxDefense()),
                getRandomDoubleFromRange(it.getMinAbsorption(), it.getMaxAbsorption()),
                getRandomDoubleFromRange(it.getMinBlockchance(), it.getMaxBlockchance()),
                getRandomIntegerFromRange(it.getMinLevel(), it.getMaxLevel()));
    }

    private static Double getRandomDoubleFromRange(Double min, Double max) {
        if (min == null || max == null) {
            return null;
        }
        return min + (max - min) * generator.nextDouble();
    }

    private static Integer getRandomIntegerFromRange(Integer min, Integer max) {
        if (min == null || max == null) {
            return null;
        }
        return min + generator.nextInt(max - min);
    }
}
