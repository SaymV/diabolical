package edu.lmu.cs.diabolical.ws.service;

import java.util.List;

import edu.lmu.cs.diabolical.ws.domain.Item;
import edu.lmu.cs.diabolical.ws.domain.ItemTemplate;

public interface ItemService {

    /**
     * Returns the item with the given id, or null if no such item exists.
     */
    Item getItemById(Long id);

    /**
     * Returns a paginated set of items that match the required query term,
     * skipping the first <code>skip</code> results and returning at most
     * <code>max</code> results.
     */
    List<Item> getItems(String query, Integer minlevel, Integer maxlevel, int skip, int max);

    /**
     * Saves the given item, which should have a null id.
     */
    Item createItem(Item item);

    /**
     * Updates or saves the given item, which should have a non-null id.
     */
    void createOrUpdateItem(Item item);

    /**
     * Returns a random spawned item that was generated based off of an item
     * template that matches supplied query terms.
     */
    Item getSpawnedItem(Integer level, String slot);

    /**
     * Returns the item template with the given id, or null if no such item template exists.
     */
    ItemTemplate getItemTemplateById(Long id);

    /**
     * Saves the given item template, which should have a null id.
     */
    ItemTemplate createItemTemplate(ItemTemplate itemTemplate);

    /**
     * Updates or saves the given item template, which should have a non-null id.
     */
    void createOrUpdateItemTemplate(ItemTemplate itemTemplate);

}
