package edu.lmu.cs.diabolical.ws.resource;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

import edu.lmu.cs.diabolical.ws.domain.Item;
import edu.lmu.cs.diabolical.ws.domain.ItemTemplate;
import edu.lmu.cs.diabolical.ws.util.DomainObjectUtils;

/**
 * Tests the item web resource.
 */
public class ItemResourceTest extends ResourceTest {
    @Test
    public void testGetItemByNonexistentId() {
        ClientResponse clientResponse = wr.path("items/17").get(ClientResponse.class);
        Assert.assertEquals(404, clientResponse.getStatus());
    }

    @Test
    public void testGetItemById() {
        Item item = wr.path("items/5000000").get(ClientResponse.class).getEntity(Item.class);
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
        List<Item> items = wr.path("items").queryParam("q", "Brace").get(new GenericType<List<Item>>() {
        });

        Assert.assertEquals(1, items.size());
    }

    @Test
    public void testGetItemsQueryByMinLevel() {
        List<Item> items = wr.path("items").queryParam("minlevel", "50").get(new GenericType<List<Item>>() {
        });

        Assert.assertEquals(1, items.size());
    }

    @Test(expected = com.sun.jersey.api.client.UniformInterfaceException.class)
    public void testGetItemsByNullQuery() {
        List<Item> items = wr.path("items").get(new GenericType<List<Item>>() {
        });

        Assert.assertEquals(2, items.size());
    }

    @Test
    public void testCreateItem() {
        Item itemToCreate = DomainObjectUtils.createItemObject("Spectral Shield", "offhand", 20.0, 35.0, 10.0, 1, 43,
                1200.0, 76.0, 40.0);

        ClientResponse response = wr.path("items").post(ClientResponse.class, itemToCreate);
        Assert.assertEquals(201, response.getStatus());
    }

    @Test
    public void testCreateItemWithSpecifiedIdProduces400() {
        Item itemToCreate = DomainObjectUtils.createItemObject("Spectral Shield", "offhand", 20.0, 35.0, 10.0, 1, 43,
                1200.0, 76.0, 40.0);

        itemToCreate.setId(500L);

        ClientResponse response = wr.path("items").post(ClientResponse.class, itemToCreate);
        Assert.assertEquals(400, response.getStatus());
    }

    @Test
    public void testUpdateItemProduces204() {
        Item itemToUpdate = DomainObjectUtils.createItemObject("Spectral Shield", "offhand", 20.0, 35.0, 10.0, 1, 43,
                1200.0, 76.0, 40.0);

        itemToUpdate.setId(5000000L);

        ClientResponse response = wr.path("items/5000000").put(ClientResponse.class, itemToUpdate);
        Assert.assertEquals(204, response.getStatus());
    }

    @Test
    public void testUpdateItemWithInconsistentIdProduces400() {
        Item itemToUpdate = new Item(100L, "Spectral Shield", "offhand", 20.0, 35.0, 10.0, 1, 43.0,
                1200.0, 76.0, 40);

        ClientResponse response = wr.path("items/5000000").put(ClientResponse.class, itemToUpdate);
        Assert.assertEquals(400, response.getStatus());
    }

    @Test
    public void testGetItemTemplateById() {
        ItemTemplate itemTemplate = wr.path("items/spawner/5000000").get(ItemTemplate.class);
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
    public void testGetSpawnedItemByLevel() {
        Item item = wr.path("items/spawner").queryParam("level", "25").get(Item.class);
        Assert.assertEquals("MyBracer", item.getName());
        Assert.assertEquals("Bracer", item.getSlot());
        Assert.assertEquals(Integer.valueOf(25), item.getLevel());
    }

    @Test
    public void testGetSpawnedItemBySlot() {
        Item item = wr.path("items/spawner").queryParam("slot", "Bracer").get(Item.class);
        Assert.assertEquals("MyBracer", item.getName());
        Assert.assertEquals("Bracer", item.getSlot());
    }

    @Test
    public void testCreateItemTemplateReturns201() {
        ItemTemplate itemTemplateToCreate = DomainObjectUtils.createItemTemplateObject("Super Soaker", "mainhand", 2.0,
                4.0, 8.0, 8.9, 0.5, 0.58, 1, 2, 5, 8, null, null, null, null, null, null);

        ClientResponse response = wr.path("items/spawner").post(ClientResponse.class, itemTemplateToCreate);
        Assert.assertEquals(201, response.getStatus());
    }

    @Test
    public void testCreateItemTemplateCanBeFound() {
        ItemTemplate itemTemplateToCreate = DomainObjectUtils.createItemTemplateObject("Super Soaker", "mainhand", 2.0,
                4.0, 8.0, 8.9, 0.5, 0.58, 1, 2, 5, 8, null, null, null, null, null, null);

        wr.path("items/spawner").post(ClientResponse.class, itemTemplateToCreate);
        ItemTemplate updatedItemTemplate = wr.path("items/spawner/1").get(ItemTemplate.class);
        itemTemplateToCreate.setId(1L);
        Assert.assertEquals(updatedItemTemplate, itemTemplateToCreate);
    }

    @Test
    public void testUpdateItemTemplateProduces204() {
        ItemTemplate itemTemplateToUpdate = DomainObjectUtils.createItemTemplateObject("Super Soaker", "mainhand", 2.0,
                4.0, 8.0, 8.9, 0.5, 0.58, 1, 2, 5, 8, null, null, null, null, null, null);

        itemTemplateToUpdate.setId(5000000L);

        ClientResponse response = wr.path("items/spawner/5000000").put(ClientResponse.class, itemTemplateToUpdate);
        Assert.assertEquals(204, response.getStatus());
    }

    @Test
    public void testUpdateItemTemplateWithInconsistentIdProduces400() {
        ItemTemplate itemTemplateToUpdate = DomainObjectUtils.createItemTemplateObject("Super Soaker", "mainhand", 2.0,
                4.0, 8.0, 8.9, 0.5, 0.58, 1, 2, 5, 8, null, null, null, null, null, null);

        ClientResponse response = wr.path("items/spawner/5000000").put(ClientResponse.class, itemTemplateToUpdate);
        Assert.assertEquals(400, response.getStatus());
    }
}
