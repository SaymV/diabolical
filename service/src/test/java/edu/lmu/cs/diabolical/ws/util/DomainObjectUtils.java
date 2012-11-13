package edu.lmu.cs.diabolical.ws.util;

import edu.lmu.cs.diabolical.ws.domain.Item;
import edu.lmu.cs.diabolical.ws.domain.ItemTemplate;

/**
 * Holder for utility methods of use to multiple unit tests.
 */
public class DomainObjectUtils {

    /**
     * Helper factory method for creating new item objects.
     */
    public static Item createItemObject(String name, String slot, Double mindamage, Double maxdamage,
            Double critchance, Integer atkspeed, Integer level, Double defense, Double absorption, Double blockchance) {
        Item item = new Item();
        item.setName(name);
        item.setSlot(slot);
        item.setMindamage(mindamage);
        item.setMaxdamage(maxdamage);
        item.setCritchance(critchance);
        item.setAtkspeed(atkspeed);
        item.setLevel(level);
        item.setDefense(defense);
        item.setAbsorption(absorption);
        item.setBlockchance(blockchance);
        return item;
    }

    public static ItemTemplate createItemTemplateObject(String name, String slot, Double minMindamage, Double maxMindamage,
            Double minMaxdamage, Double maxMaxdamage, Double minCritchance, Double maxCritchance, Integer minAtkspeed,
            Integer maxAtkspeed, Integer minLevel, Integer maxLevel, Double minDefense, Double maxDefense,
            Double minAbsorption, Double maxAbsorption, Double minBlockchance, Double maxBlockchance) {
        ItemTemplate itemTemplate = new ItemTemplate();
        itemTemplate.setName(name);
        itemTemplate.setSlot(slot);
        itemTemplate.setDamageRange(minMindamage, maxMindamage, minMaxdamage, maxMaxdamage);
        itemTemplate.setCritchanceRange(minCritchance, maxCritchance);
        itemTemplate.setAtkspeedRange(minAtkspeed, maxAtkspeed);
        itemTemplate.setLevelRange(minLevel, maxLevel);
        itemTemplate.setDefenseRange(minDefense, maxDefense);
        itemTemplate.setAbsorptionRange(minAbsorption, maxAbsorption);
        itemTemplate.setBlockchanceRange(minBlockchance, maxBlockchance);
        return itemTemplate;
    }

    public static Item createItemObject(int i, String string, String string2) {
        // TODO Auto-generated method stub
        return null;
    }

}
