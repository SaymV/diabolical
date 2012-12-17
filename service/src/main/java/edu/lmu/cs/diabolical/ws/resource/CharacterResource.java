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

    String INVALID_CHARACTER_ID = "Character ID invalid or missing.";
    String CHARACTER_NOT_PROVIDED = "No character object payload provided.";
    String CHARACTER_NOT_FOUND = "Character not found.";
    String NO_CHARACTER_QUERY_PARAMS_PROVIDED = "Character query parameters not provided.";
    String NO_CHARACTERS_FOUND_WITH_GIVEN_PARAMS = "No characters were found that matched your parameters.";

    @GET
    @Path("/{id}")
    Character getCharacterById(@PathParam("id") Integer id);

    @GET
    @Path("/")
    List<Character> getCharactersByQuery(@QueryParam("name") String name,
            @QueryParam("className") String className, @QueryParam("gender") Gender gender,
            @QueryParam("minLevel") Integer minLevel, @QueryParam("maxLevel") Integer maxLevel);

    @GET
    @Path("/spawn")
    Character spawnRandomCharacter();

    @DELETE
    @Path("/{id}")
    Response deleteCharacterById(@PathParam("id") Integer id);

    @PUT
    @Path("/")
    Character updateCharacter(Character c);

    @PUT
    @Path("/update")
    Character updateCharacterByIdWithSpecifiedFields(Character c);

    @POST
    @Path("/")
    Response createCharacter(Character c);

}
