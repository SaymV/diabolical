package edu.lmu.cs.diabolical.ws.resource;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import edu.lmu.cs.diabolical.ws.domain.Item;
import edu.lmu.cs.diabolical.ws.domain.ItemTemplate;
import edu.lmu.cs.diabolical.ws.service.ItemService;

@Path("/items")
public class ItemResourceImpl extends AbstractResource implements ItemResource {

    private ItemService itemService;

    // TODO: Re-implement user authentication.
    public ItemResourceImpl(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public List<Item> getItems(String query, Integer minlevel, Integer maxlevel, int skip, int max) {
        logServiceCall();

        validate((query != null || minlevel != null || maxlevel != null), Response.Status.BAD_REQUEST,
                ITEM_QUERY_PARAMETERS_MISSING);

        return itemService.getItems(preprocessNullableQuery(query, skip, max, 0, 100), minlevel, maxlevel,
                skip, max);
    }

    @Override
    public Item getItemById(Long id) {
        logServiceCall();

        Item item = itemService.getItemById(id);
        validate(item != null, Response.Status.NOT_FOUND, ITEM_NOT_FOUND);

        return item;
    }

    @Override
    public Response createItem(Item item) {
        logServiceCall();

        validate(item.getId() == null, Response.Status.BAD_REQUEST, ITEM_OVERSPECIFIED);
        item = itemService.createItem(item);

        return Response.created(java.net.URI.create(Long.toString(item.getId()))).build();
    }

    @Override
    public Response createOrUpdateItem(Long id, Item item) {
        logServiceCall();

        validate(id.equals(item.getId()), Response.Status.BAD_REQUEST, ITEM_INCONSISTENT);
        itemService.createOrUpdateItem(item);

        return Response.noContent().build();
    }

    @Override
    public Item getSpawnedItem(@QueryParam("level") Integer level, @QueryParam("slot") String slot) {
        logServiceCall();

        validate((level != null || slot != null), Response.Status.BAD_REQUEST,
                SPAWNER_PARAMETERS_MISSING);

        return itemService.getSpawnedItem(level, slot);
    }

    @Override
    public ItemTemplate getItemTemplateById(@PathParam("id") Long id) {
        logServiceCall();

        ItemTemplate itemTemplate = itemService.getItemTemplateById(id);
        validate(itemTemplate != null, Response.Status.NOT_FOUND, ITEM_TEMPLATE_NOT_FOUND);

        return itemTemplate;
    }

    @Override
    public Response createItemTemplate(ItemTemplate itemTemplate) {
        logServiceCall();

        validate(itemTemplate.getId() == null, Response.Status.BAD_REQUEST, ITEM_TEMPLATE_OVERSPECIFIED);
        itemTemplate = itemService.createItemTemplate(itemTemplate);

        return Response.created(java.net.URI.create(Long.toString(itemTemplate.getId()))).build();
    }

    @Override
    public Response createOrUpdateItemTemplate(@PathParam("id") Long id, ItemTemplate itemTemplate) {
        logServiceCall();

        validate(id.equals(itemTemplate.getId()), Response.Status.BAD_REQUEST, ITEM_TEMPLATE_INCONSISTENT);
        itemService.createOrUpdateItemTemplate(itemTemplate);

        return Response.noContent().build();
    }

}
