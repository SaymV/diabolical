package edu.lmu.cs.diabolical.ws.resource;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
        assertEquals(404, clientResponse.getStatus());
    }

    @Test
    public void testGetItemById() {
        Item item = wr.path("items/5000000").get(ClientResponse.class).getEntity(Item.class);
        assertEquals(Long.valueOf(5000000L), item.getId());
        assertEquals("MyBracer", item.getName());
        assertEquals("Bracer", item.getSlot());
        assertEquals(Double.valueOf(1600.0), item.getMindamage());
        assertEquals(Double.valueOf(1450.0), item.getMaxdamage());
        assertEquals(Double.valueOf(90.0), item.getCritchance());
        assertEquals(Integer.valueOf(2), item.getAtkspeed());
        assertEquals(Double.valueOf(99.9), item.getDefense());
        assertEquals(Double.valueOf(99.8), item.getAbsorption());
        assertEquals(Double.valueOf(99.7), item.getBlockchance());
        assertEquals(Integer.valueOf(30), item.getLevel());
    }

    @Test
    public void testGetItemsQueryBySlot() {
        List<Item> items = wr.path("items").queryParam("q", "Brace").get(new GenericType<List<Item>>() {
        });

        assertEquals(1, items.size());
    }

    @Test
    public void testGetItemsQueryByMinLevel() {
        List<Item> items = wr.path("items").queryParam("minlevel", "50").get(new GenericType<List<Item>>() {
        });

        assertEquals(1, items.size());
    }

    @Test(expected = com.sun.jersey.api.client.UniformInterfaceException.class)
    public void testGetItemsByNullQuery() {
        List<Item> items = wr.path("items").get(new GenericType<List<Item>>() {
        });

        assertEquals(2, items.size());
    }

    @Test
    public void testCreateItem() {
        Item itemToCreate = DomainObjectUtils.createItemObject("Spectral Shield", "offhand", 20.0, 35.0, 10.0, 1, 43,
                1200.0, 76.0, 40.0);

        ClientResponse response = wr.path("items").post(ClientResponse.class, itemToCreate);
        assertEquals(201, response.getStatus());
    }

    @Test
    public void testCreateItemWithSpecifiedIdProduces400() {
        Item itemToCreate = DomainObjectUtils.createItemObject("Spectral Shield", "offhand", 20.0, 35.0, 10.0, 1, 43,
                1200.0, 76.0, 40.0);

        itemToCreate.setId(500L);

        ClientResponse response = wr.path("items").post(ClientResponse.class, itemToCreate);
        assertEquals(400, response.getStatus());
    }

    @Test
    public void testUpdateItemProduces204() {
        Item itemToUpdate = DomainObjectUtils.createItemObject("Spectral Shield", "offhand", 20.0, 35.0, 10.0, 1, 43,
                1200.0, 76.0, 40.0);

        itemToUpdate.setId(5000000L);

        ClientResponse response = wr.path("items/5000000").put(ClientResponse.class, itemToUpdate);
        assertEquals(204, response.getStatus());
    }

    @Test
    public void testUpdateItemWithInconsistentIdProduces400() {
        Item itemToUpdate = new Item(100L, "Spectral Shield", "offhand", 20.0, 35.0, 10.0, 1, 43.0,
                1200.0, 76.0, 40);

        ClientResponse response = wr.path("items/5000000").put(ClientResponse.class, itemToUpdate);
        assertEquals(400, response.getStatus());
    }
}
