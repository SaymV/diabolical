package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

import edu.lmu.cs.diabolical.ws.domain.Item;

/**
 * Simple dao for item domain objects.
 */
public interface ItemDao {
    /**
     * Returns the item with the given id, or null if no such item exists.
     */
    Item getItemById(Long id);

    /**
     * Returns a paginated set of items that match the required query term, skipping the first <code>skip</code> results
     * and returning at most <code>max</code> results.
     */
    List<Item> getItems(String slot, Integer minLevel, Integer maxLevel, int skip, int max);

    // TODO stats queries

    /**
     * Saves the given item, which should have a null id.
     */
    Item createItem(Item item);

    /**
     * Updates or saves the given item, which should have a non-null id.
     */
    void createOrUpdateItem(Item item);

}
