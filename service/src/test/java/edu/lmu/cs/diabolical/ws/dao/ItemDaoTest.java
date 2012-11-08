package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import edu.lmu.cs.diabolical.ws.domain.Item;
import edu.lmu.cs.diabolical.ws.util.ApplicationContextTest;
import edu.lmu.cs.diabolical.ws.util.DomainObjectUtils;

public class ItemDaoTest extends ApplicationContextTest {

    private ItemDao itemDao;

    @Before
    public void getRequiredBeans() {
        itemDao = (ItemDao) applicationContext.getBean("itemDao");
    }

    @Test
    public void testGetItemById() {
        // Grab the known event in the fixture.
        Item item = itemDao.getItemById(5000000L);

        Assert.assertEquals(Long.valueOf(5000000L), item.getId());
        Assert.assertEquals("MyBracer", item.getName());
        Assert.assertEquals("Bracer", item.getSlot());
        Assert.assertEquals(1600.0, item.getMindamage());
        Assert.assertEquals(1450.0, item.getMaxdamage());
        Assert.assertEquals(90.0, item.getCritchance());
        Assert.assertEquals(2, item.getAtkspeed().intValue());
        Assert.assertEquals(99.9, item.getDefense());
        Assert.assertEquals(99.8, item.getAbsorption());
        Assert.assertEquals(99.7, item.getBlockchance());
        Assert.assertEquals(30, item.getLevel().intValue());
    }

    @Test
    public void testGetItemsBySlot() {
        List<Item> items = itemDao.getItems("Brace", null, null, 0, 5);

        // There should only be one grant there. We'll check just the ID.
        Assert.assertEquals(1, items.size());
        Assert.assertEquals(Long.valueOf(5000000L), items.get(0).getId());
    }

    @Test
    public void testGetItemsByMinLevel() {
        List<Item> items = itemDao.getItems(null, 40, null, 0, 10);
        Assert.assertEquals(1, items.size());
        Assert.assertEquals(Long.valueOf(5000001L), items.get(0).getId());
    }

    @Test
    public void testGetItemsByMaxLevel() {
        List<Item> items = itemDao.getItems(null, null, 40, 0, 10);
        Assert.assertEquals(1, items.size());
        Assert.assertEquals(Long.valueOf(5000000L), items.get(0).getId());
    }

    @Test
    public void testGetItemsByInvalidQuery() {
        List<Item> items = itemDao.getItems("blarg", null, null, 0, 5);
        Assert.assertEquals(0, items.size());
    }

    @Test
    public void testCreateItem() {
        // Create an id-less grant.
        Item itemToCreate = DomainObjectUtils.createItemObject("Super Soaker", "mainhand", 2.0, 4.0, 5.0, 1, 5, 80.0,
                null, null);

        itemDao.createItem(itemToCreate);

        // The created grant should now have an ID of 1 because there is
        // nothing else in the text fixture.
        Assert.assertEquals(Long.valueOf(1L), itemToCreate.getId());

        // Reload the grant that was just created.
        Item createdItem = itemDao.getItemById(1L);
        assertSimpleEquality(itemToCreate, createdItem);
    }

    @Test
    public void testCreateAndUpdateItem() {
        // Create an id-less item.
        Item itemToCreate = DomainObjectUtils.createItemObject("Super Soaker", "mainhand", 2.0, 4.0, 5.0, 1, 5, 80.0,
                null, null);
        Item itemToReplaceWith = DomainObjectUtils.createItemObject("Super Soaker", "mainhand", null, null, null, 1, 5,
                80.0, 25.0, 76.25);

        itemDao.createItem(itemToCreate);

        // Keep the ID of the created item to make sure it does not change when updated.
        Long createdItemId = itemToCreate.getId();
        itemToReplaceWith.setId(createdItemId);

        // Reload the item that was just created with a new item with the same ID.
        itemDao.createOrUpdateItem(itemToReplaceWith);
        Item createdItem = itemDao.getItemById(createdItemId);

        assertSimpleEquality(itemToReplaceWith, createdItem);
        Assert.assertNotSame(createdItem.getName(), itemToCreate.getName());
        Assert.assertNotSame(createdItem.getSlot(), itemToCreate.getSlot());
        Assert.assertNotSame(createdItem.getMindamage(), itemToCreate.getMindamage());
        Assert.assertNotSame(createdItem.getMaxdamage(), itemToCreate.getMaxdamage());
    }

    /**
     * Helper function for asserting the equality of two items.
     */
    private void assertSimpleEquality(Item item1, Item item2) {
        Assert.assertEquals(item1.getId(), item2.getId());
        Assert.assertEquals(item1.getName(), item2.getName());
        Assert.assertEquals(item1.getSlot(), item2.getSlot());
        Assert.assertEquals(item1.getDefense(), item2.getDefense());
        Assert.assertEquals(item1.getLevel(), item2.getLevel());
    }
}
