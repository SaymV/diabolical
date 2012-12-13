package edu.lmu.cs.diabolical.ws.service;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import edu.lmu.cs.diabolical.ws.domain.Item;
import edu.lmu.cs.diabolical.ws.domain.ItemTemplate;
import edu.lmu.cs.diabolical.ws.service.ItemService;
import edu.lmu.cs.diabolical.ws.util.ApplicationContextTest;
import edu.lmu.cs.diabolical.ws.util.DomainObjectUtils;

public class ItemServiceTest extends ApplicationContextTest {
    private ItemService itemService;

    @Before
    public void setUp() {
        itemService = (ItemService) applicationContext.getBean("itemService");
    }

    @Test
    public void testFindItemById() {
        Item item = itemService.getItemById(Long.valueOf(5000000L));
        Assert.assertEquals(Long.valueOf(5000000L), item.getId());
        Assert.assertEquals("MyBracer", item.getName());
        Assert.assertEquals("Bracer", item.getSlot());
        Assert.assertEquals(Double.valueOf(1600.0), item.getMindamage());
        Assert.assertEquals(Double.valueOf(1450.0), item.getMaxdamage());
        Assert.assertEquals(Double.valueOf(90.0), item.getCritchance());
        Assert.assertEquals(Integer.valueOf(2), item.getAtkspeed());
        Assert.assertEquals(Double.valueOf(99.9), item.getDefense());
        Assert.assertEquals(Double.valueOf(99.8), item.getAbsorption());
        Assert.assertEquals(Double.valueOf(99.7), item.getBlockchance());
        Assert.assertEquals(Integer.valueOf(30), item.getLevel());
    }
    @Test
    public void testGetItemsQueryBySlot() {
        List<Item> items = itemService.getItems("Brace", null, null, 0, 5);

        Assert.assertEquals(1, items.size());
    }

    @Test
    public void testGetItemsQueryByMinLevel() {
        List<Item> items = itemService.getItems(null, 50, null, 0, 5);

        Assert.assertEquals(1, items.size());
    }

    @Test
    public void testCreateItem() {
        Item itemToCreate = DomainObjectUtils.createItemObject("Spectral Shield", "offhand", 20.0, 35.0, 10.0, 1, 43,
                1200.0, 76.0, 40.0);

        Item itemCreated = itemService.createItem(itemToCreate);
        Assert.assertEquals(itemToCreate, itemCreated);
    }

    @Test
    public void testUpdateItem() {
        Item itemToUpdate = DomainObjectUtils.createItemObject("Spectral Shield", "offhand", 20.0, 35.0, 10.0, 1, 43,
                1200.0, 76.0, 40.0);

        itemToUpdate.setId(5000000L);

        itemService.createOrUpdateItem(itemToUpdate);
        Item itemUpdated = itemService.getItemById(5000000L);
        Assert.assertEquals(itemToUpdate, itemUpdated);
    }

    @Test
    public void testGetItemTemplateById() {
        ItemTemplate itemTemplate = itemService.getItemTemplateById(Long.valueOf(5000000L));
        Assert.assertEquals(Long.valueOf(5000000L), itemTemplate.getId());
        Assert.assertEquals("MyBracer", itemTemplate.getName());
        Assert.assertEquals("Bracer", itemTemplate.getSlot());
        Assert.assertEquals(1400.0, itemTemplate.getMinMindamage());
        Assert.assertEquals(1450.0, itemTemplate.getMaxMindamage());
        Assert.assertEquals(1700.0, itemTemplate.getMinMaxdamage());
        Assert.assertEquals(1750.0, itemTemplate.getMaxMaxdamage());
        Assert.assertEquals(0.9, itemTemplate.getMinCritchance());
        Assert.assertEquals(0.99, itemTemplate.getMaxCritchance());
        Assert.assertEquals(2, itemTemplate.getMinAtkspeed().intValue());
        Assert.assertEquals(5, itemTemplate.getMaxAtkspeed().intValue());
        Assert.assertEquals(20, itemTemplate.getMinLevel().intValue());
        Assert.assertEquals(30, itemTemplate.getMaxLevel().intValue());
    }

    @Test
    public void testGetSpawnedItem() {
        Item item = itemService.getSpawnedItem(25, null);
        Assert.assertEquals("MyBracer", item.getName());
        Assert.assertEquals("Bracer", item.getSlot());
    }
}
