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
     * Returns a set of item templates that match the specified query terms.
     */
    List<ItemTemplate> getItemTemplates(Integer level, String slot);

    /**
     * Saves the given item template, which should have a null id.
     */
    ItemTemplate createItemTemplate(ItemTemplate itemTemplate);

    /**
     * Updates or saves the given item template, which should have a non-null id.
     */
    void createOrUpdateItemTemplate(ItemTemplate itemTemplate);

}
