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
    @Path("/{id}")
    public Character getCharacterById(@PathParam("id") Integer id);

    @GET
    @Path("/")
    public List<Character> getCharactersByQuery(@QueryParam("name") String name,
            @QueryParam("className") String className, @QueryParam("gender") Gender gender,
            @QueryParam("minLevel") Integer minLevel, @QueryParam("maxLevel") Integer maxLevel);

    @GET
    @Path("/spawn")
    public Character spawnRandomCharacter();

    @DELETE
    @Path("/{id}")
    public Response deleteCharacterById(@PathParam("id") Integer id);

    @PUT
    @Path("/")
    public Character updateCharacter(Character c);

    @PUT
    @Path("/update")
    public Character updateCharacterByIdWithSpecifiedFields(Character c);

    @POST
    @Path("/")
    public Response createCharacter(Character c);

}
