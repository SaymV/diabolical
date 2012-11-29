package edu.lmu.cs.diabolical.ws.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.lmu.cs.diabolical.ws.domain.Item;
import edu.lmu.cs.diabolical.ws.domain.ItemTemplate;
import edu.lmu.cs.diabolical.ws.util.ServiceException;

/**
 * The JAX-RS interface for operating on item resources.
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ItemResource {
    /**
     * Possible resource error messages.
     */
    String ITEM_OVERSPECIFIED = "item.overspecified";
    String ITEM_TEMPLATE_OVERSPECIFIED = "item.template.overspecified";
    String ITEM_INCONSISTENT = "item.inconsistent";
    String ITEM_TEMPLATE_INCONSISTENT = "item.template.inconsistent";
    String ITEM_NOT_FOUND = "item.not.found";
    String ITEM_TEMPLATE_NOT_FOUND = "item.template.not.found";
    String ITEM_QUERY_PARAMETERS_MISSING = "item.query.parameters.missing";

    /**
     * Returns items according to the search parameters
     *
     * @param query
     *            The query
     * @param minlevel
     *            Minimum level of item to query
     * @param maxlevel
     *            Maximum level of item to query
     * @param skip
     *            The number of initial results to skip
     * @param max
     *            The maximum number of results to display
     * @return the (paginated) set of items matching the query parameters
     */
    @GET
    List<Item> getItems(@QueryParam("q") String query, @QueryParam("minlevel") Integer minlevel,
            @QueryParam("maxlevel") Integer maxlevel, @QueryParam("skip") @DefaultValue("0") int skip,
            @QueryParam("max") @DefaultValue("100") int max);

    /**
     * Creates an item for which the server will generate the id.
     *
     * @param item
     *            The item object to create. The item must have a null id.
     * @return A response with HTTP 201 on success, or a response with HTTP 400 and message
     *         <code>item.overspecified</code> if the item's id is not null.
     */
    @POST
    Response createItem(Item item);

    /**
     * Supposed to save the representation of the item with the given id. Inconsistent data should result in HTTP 400,
     * while a successful PUT should return Response.noContent.
     *
     * @param id
     *            The id of the item to save.
     * @return A response with HTTP 204 no content on success, or a response with HTTP 400 and message
     *         <code>item.inconsistent</code> if checked data does not have the save id as requested in the URL.
     */
    // TODO: Update roles.
    @PUT
    @Path("{id}")
    Response createOrUpdateItem(@PathParam("id") Long id, Item item);

    /**
     * Returns the item with the given id.
     *
     * @param id
     *            The id of the requested item.
     * @return the item with the given id.
     * @throws ServiceException
     *             if there is no item with the given id, causing the framework to generate an HTTP 404.
     */
    @GET
    @Path("{id}")
    Item getItemById(@PathParam("id") Long id);

    /**
     * Returns a random item based upon an existing template according to the given parameters
     *
     * @param level
     *            Level of item to spawn
     * @param slot
     *            Slot of item to spawn
     * @return a spawned, or random, item based upon an item template and according to given parameters
     */
    @GET
    @Path("/spawner")
    Item getSpawnedItem(@QueryParam("level") Integer level, @QueryParam("slot") String slot);

    /**
     * Returns the item template with the given id.
     *
     * @param id
     *            The id of the requested item template.
     * @return the item template with the given id.
     * @throws ServiceException
     *             if there is no item template with the given id, causing the framework to generate an HTTP 404.
     */
    @GET
    @Path("/spawner/{id}")
    ItemTemplate getItemTemplateById(@PathParam("id") Long id);

    /**
     * Creates an item template for which the server will generate the id.
     *
     * @param itemTemplate
     *            The item template object to create. The item template must have a null id.
     * @return A response with HTTP 201 on success, or a response with HTTP 400 and message
     *         <code>item.template.overspecified</code> if the item template's id is not null.
     */
    @POST
    @Path("/spawner")
    Response createItemTemplate(ItemTemplate itemTemplate);

    /**
     * Supposed to save the representation of the item template with the given id. Inconsistent
     * data should result in HTTP 400, while a successful PUT should return Response.noContent.
     *
     * @param id
     *            The id of the item template to save.
     * @return A response with HTTP 204 no content on success, or a response with HTTP 400 and message
     *         <code>item.template.inconsistent</code> if checked data does not have the same id as
     *         requested in the URL.
     */
    // TODO: Update roles.
    @PUT
    @Path("/spawner/{id}")
    Response createOrUpdateItemTemplate(@PathParam("id") Long id, ItemTemplate itemTemplate);
}
