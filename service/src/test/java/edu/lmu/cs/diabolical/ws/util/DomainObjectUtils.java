package edu.lmu.cs.diabolical.ws.util;

import edu.lmu.cs.diabolical.ws.domain.Item;

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

    public static Item createItemObject(int i, String string, String string2) {
        // TODO Auto-generated method stub
        return null;
    }

}
