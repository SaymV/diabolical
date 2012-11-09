package edu.lmu.cs.diabolical.ws.resource;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

import edu.lmu.cs.diabolical.ws.domain.Item;
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
}
