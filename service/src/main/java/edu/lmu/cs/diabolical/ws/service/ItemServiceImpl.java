package edu.lmu.cs.diabolical.ws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.lmu.cs.diabolical.ws.dao.ItemDao;
import edu.lmu.cs.diabolical.ws.dao.ItemTemplateDao;
import edu.lmu.cs.diabolical.ws.domain.Item;
import edu.lmu.cs.diabolical.ws.domain.ItemTemplate;
import edu.lmu.cs.diabolical.ws.domain.util.ItemGenerator;

public class ItemServiceImpl extends AbstractService implements ItemService {

    private ItemDao itemDao;
    private ItemTemplateDao itemTemplateDao;

    public ItemServiceImpl(ItemDao itemDao, ItemTemplateDao itemTemplateDao) {
        this.itemDao = itemDao;
        this.itemTemplateDao = itemTemplateDao;
    }

    @Override
    public List<Item> getItems(String query, Integer minlevel, Integer maxlevel, int skip, int max) {
        getLogger().debug("getItems");
        return itemDao.getItems(query, minlevel, maxlevel, skip, max);
    }

    @Override
    public Item getItemById(Long id) {
        getLogger().debug("getItemById");
        return itemDao.getItemById(id);
    }

    @Override
    public Item createItem(Item item) {
        getLogger().debug("createItem");
        return itemDao.createItem(item);
    }

    @Override
    public void createOrUpdateItem(Item item) {
        getLogger().debug("createOrUpdateItem");
        itemDao.createOrUpdateItem(item);
    }

    @Override
    public Item getSpawnedItem(Integer level, String slot) {
        getLogger().debug("getSpawnedItem");
        ArrayList<ItemTemplate> itemTemplates = new ArrayList<ItemTemplate>(itemTemplateDao.getItemTemplates(level,
                slot));
        return ItemGenerator.generateRandomItem(itemTemplates.get(new Random().nextInt(itemTemplates.size())));
    }

    @Override
    public ItemTemplate getItemTemplateById(Long id) {
        getLogger().debug("getItemTemplateById");
        return itemTemplateDao.getItemTemplateById(id);
    }

    @Override
    public ItemTemplate createItemTemplate(ItemTemplate itemTemplate) {
        getLogger().debug("createItemTemplate");
        return itemTemplateDao.createItemTemplate(itemTemplate);
    }

    @Override
    public void createOrUpdateItemTemplate(ItemTemplate itemTemplate) {
        getLogger().debug("createOrUpdateItemTemplate");
        itemTemplateDao.createOrUpdateItemTemplate(itemTemplate);
    }

}
