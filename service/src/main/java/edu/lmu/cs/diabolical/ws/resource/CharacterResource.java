package edu.lmu.cs.diabolical.ws.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.lmu.cs.diabolical.ws.domain.Character;
import edu.lmu.cs.diabolical.ws.domain.Gender;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CharacterResource {
    @GET
    @Path("/characters/{id}")
    public Character getCharacterById(@PathParam("id") Integer id);

    @GET
    @Path("/characters")
    public List<Character> getCharactersByQuery(@QueryParam("name") String name,
            @QueryParam("className") String className, @QueryParam("gender") Gender gender,
            @QueryParam("minLevel") Integer minLevel, @QueryParam("maxLevel") Integer maxLevel);

    @GET
    @Path("/characters/spawn")
    public Character spawnRandomCharacter();

    @DELETE
    @Path("/characters/{id}")
    public Response deleteCharacterById(@PathParam("id") Integer id);

    @PUT
    @Path("/characters")
    public Character updateCharacter(Character c);

    @PATCH
    @Path("/characters")
    public Character updateCharacterByIdWithSpecifiedFields(Character c);

    @POST
    @Path("/characters")
    public Response createCharacter(Character c);

}
