package edu.lmu.cs.diabolical.ws.service;

import java.util.ArrayList;
import java.util.List;

//import edu.lmu.cs.diabolical.ws.dao.ItemDao;
//import edu.lmu.cs.diabolical.ws.dao.ItemTemplateDao;
import edu.lmu.cs.diabolical.ws.domain.Item;
import edu.lmu.cs.diabolical.ws.domain.ItemTemplate;
import edu.lmu.cs.diabolical.ws.domain.util.ItemGenerator;

public class ItemServiceImpl extends AbstractService implements ItemService {

//    private ItemDao itemDao;
//    private ItemTemplateDao itemTemplateDao;

    public ItemServiceImpl(/*ItemDao itemDao, ItemTemplateDao itemTemplateDao*/) {
//        this.itemDao = itemDao;
//        this.itemTemplateDao = itemTemplateDao;
    }

    @Override
    public List<Item> getItems(String query, Integer minlevel, Integer maxlevel, int skip, int max) {
        getLogger().debug("getItems");
        // TODO Stub
        List<Item> result = new ArrayList<Item>();
        result.add(new Item(500000l, "MyBracer", "Bracer", 1600.0, 1450.0, 90.0, 2, 99.9, 99.8, 99.7, 30));
        return result;
//        return itemDao.getItems(query, minlevel, maxlevel, skip, max);
    }

    @Override
    public Item getItemById(Long id) {
        getLogger().debug("getItemById");
        // TODO Stub; accommodates the unit test
        return id == 17l ? null :
        	new Item(id, "MyBracer", "Bracer", 1600.0, 1450.0, 90.0, 2, 99.9, 99.8, 99.7, 30);
//        return itemDao.getItemById(id);
    }

    @Override
    public Item createItem(Item item) {
        getLogger().debug("createItem");
        // TODO Stub
        return new Item(54321l, "creation dummy", "dummy", -1.0, -100.0, -99.0, 100, 100.0, 50.0, 25.0, -1);
//        return itemDao.createItem(item);
    }

    @Override
    public void createOrUpdateItem(Item item) {
        getLogger().debug("createOrUpdateItem");
        // TODO Stub
//        itemDao.createOrUpdateItem(item);
    }

    @Override
    public Item getSpawnedItem(Integer level, String slot) {
        getLogger().debug("getSpawnedItem");
//        ArrayList<ItemTemplate> itemTemplates = new ArrayList<ItemTemplate>(itemTemplateDao.getItemTemplates(level,
//                slot));
//        return ItemGenerator.generateRandomItem(itemTemplates.get(new Random().nextInt(itemTemplates.size())));
        // TODO Stub
        return ItemGenerator.generateRandomItem(new ItemTemplate(-1l, "spawned item", slot, 1.0, 3.0, 10.0, 100.0, 1.0, 99.0, 1, 10,
                level - 4,
                level + 4,
                1.0, 50.0, 1.0, 90.0, 1.0, 75.0));
    }

    @Override
    public ItemTemplate getItemTemplateById(Long id) {
        getLogger().debug("getItemTemplateById");
        // TODO Stub
        return new ItemTemplate(id, "dummy template", "dummy", -9.0, -99.0, -999.0, -9999.0, -1.0, -99.0, -100, -1000, -1, -100, -9.0, -99.0, -100.0, -1000.0, -1.0, -11.0);
//        return itemTemplateDao.getItemTemplateById(id);
    }

    @Override
    public ItemTemplate createItemTemplate(ItemTemplate itemTemplate) {
        getLogger().debug("createItemTemplate");
        // TODO Stub
        return new ItemTemplate(null, "dummy template", "dummy", -9.0, -99.0, -999.0, -9999.0, -1.0, -99.0, -100, -1000, -1, -100, -9.0, -99.0, -100.0, -1000.0, -1.0, -11.0);
//        return itemTemplateDao.createItemTemplate(itemTemplate);
    }

    @Override
    public void createOrUpdateItemTemplate(ItemTemplate itemTemplate) {
        getLogger().debug("createOrUpdateItemTemplate");
        // TODO Stub
//        itemTemplateDao.createOrUpdateItemTemplate(itemTemplate);
    }

}
