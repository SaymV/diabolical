package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

import edu.lmu.cs.diabolical.ws.domain.ItemTemplate;

/**
 * Simple dao for item template domain objects.
 */
public interface ItemTemplateDao {
    /**
     * Returns the item template with the given id, or null if no such item exists.
     */
    ItemTemplate getItemTemplateById(Long id);

    /**
     * Returns a paginated set of item templates that match the required query term, skipping the first
     * <code>skip</code> results and returning at most <code>max</code> results.
     */
    List<ItemTemplate> getItemTemplates(String slot, Integer level, int skip, int max);

    /**
     * Saves the given item template, which should have a null id.
     */
    ItemTemplate createItemTemplate(ItemTemplate itemTemplate);

    /**
     * Updates or saves the given item template, which should have a non-null id.
     */
    void createOrUpdateItemTemplate(ItemTemplate itemTemplate);

}
