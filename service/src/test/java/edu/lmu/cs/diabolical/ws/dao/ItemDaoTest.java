package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import edu.lmu.cs.diabolical.ws.domain.Item;
import edu.lmu.cs.diabolical.ws.util.ApplicationContextTest;

public class ItemDaoTest extends ApplicationContextTest {

    private ItemDao itemDao;

    @Before
    public void getRequiredBeans() {
        itemDao = (ItemDao) applicationContext.getBean("itemDao");
    }

    @Test
    public void testGetGrantById() {
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
    public void testGetGrantsByMinLevel() {
        List<Item> items = itemDao.getItems(null, 40, null, 0, 10);
        Assert.assertEquals(1, items.size());
        Assert.assertEquals(Long.valueOf(5000001L), items.get(0).getId());
    }

    @Test
    public void testGetGrantsByMaxLevel() {
        List<Item> items = itemDao.getItems(null, null, 40, 0, 10);
        Assert.assertEquals(1, items.size());
        Assert.assertEquals(Long.valueOf(5000000L), items.get(0).getId());
    }

    @Test
    public void testGetItemsByInvalidQuery() {
        List<Item> items = itemDao.getItems("blarg", null, null, 0, 5);
        Assert.assertEquals(0, items.size());
    }
}
