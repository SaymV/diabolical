package edu.lmu.cs.diabolical.ws.resource;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CharacterResource {
    @GET
    @Path("/characters/{id}")
    public Character getCharacterById(@PathParam("id") String id);
    
    @GET
    @Path("/characters")
    public List<Character> getCharactersByQuery(
            @DefaultValue("") @QueryParam("name") String name,
            @DefaultValue("") @QueryParam("class") String className,
            @DefaultValue("") @QueryParam("gender") String gender,
            @DefaultValue("") @QueryParam("minLevel") String minLevel,
            @DefaultValue("") @QueryParam("maxLevel") String maxLevel,
            @DefaultValue("") @QueryParam("skill") String skill);
    
    @GET
    @Path("/characters/spawners")
    public Character spawnRandomCharacter();
    
    @DELETE
    @Path("/characters/{id}")
    public Response deleteCharacterById(@PathParam("id") String id);
    
    @PUT
    @Path("/characters/{id}")
    public Character updateCharacterById(@PathParam("id") String id);
    
    @PATCH
    @Path("/characters/{id}")
    public Character updateCharacterByIdWithSpecifiedFields(@PathParam("id") String id);
    
    @POST
    @Path("/characters")
    public Response createCharacter(Character c);
    
}
