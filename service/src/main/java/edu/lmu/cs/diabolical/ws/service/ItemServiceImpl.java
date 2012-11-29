package edu.lmu.cs.diabolical.ws.service;

import java.util.List;

import edu.lmu.cs.diabolical.ws.dao.ItemDao;
import edu.lmu.cs.diabolical.ws.domain.Item;
import edu.lmu.cs.diabolical.ws.domain.ItemTemplate;

public class ItemServiceImpl extends AbstractService implements ItemService {

    private ItemDao itemDao;

    public ItemServiceImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public List<Item> getItems(String query, Integer minlevel, Integer maxlevel, int skip, int max) {
        getLogger().debug("getItems");
        return itemDao.getItems(query, minlevel, maxlevel, skip, max);
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
    public Item getItemById(Long id) {
        getLogger().debug("getItemById");
        return itemDao.getItemById(id);
    }

    @Override
    public Item getSpawnedItem(Integer level, String slot) {
        getLogger().debug("getSpawnedItem");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemTemplate getItemTemplateById(Long id) {
        getLogger().debug("getItemTemplateById");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemTemplate createItemTemplate(ItemTemplate itemTemplate) {
        getLogger().debug("createItemTemplate");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createOrUpdateItemTemplate(ItemTemplate itemTemplate) {
        getLogger().debug("createOrUpdateItemTemplate");
        // TODO Auto-generated method stub

    }

}
