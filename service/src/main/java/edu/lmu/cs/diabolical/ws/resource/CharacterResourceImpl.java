package edu.lmu.cs.diabolical.ws.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import edu.lmu.cs.diabolical.ws.service.CharacterService;

public class CharacterResourceImpl extends AbstractResource implements CharacterResource {

    CharacterService characterService;

    public CharacterResourceImpl(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Override
    @GET
    @Path("/characters/{id}")
    public Character getCharacterById(@PathParam("id") String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @GET
    @Path("/characters")
    public List<Character> getCharactersByQuery(@DefaultValue("") @QueryParam("name") String name,
            @DefaultValue("") @QueryParam("class") String className,
            @DefaultValue("") @QueryParam("gender") String gender,
            @DefaultValue("") @QueryParam("minLevel") String minLevel,
            @DefaultValue("") @QueryParam("maxLevel") String maxLevel,
            @DefaultValue("") @QueryParam("skill") String skill) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @GET
    @Path("/characters/spawners")
    public Character spawnRandomCharacter() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @DELETE
    @Path("/characters/{id}")
    public Response deleteCharacterById(@PathParam("id") String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @PUT
    @Path("/characters/{id}")
    public Character updateCharacterById(@PathParam("id") String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @PATCH
    @Path("/characters/{id}")
    public Character updateCharacterByIdWithSpecifiedFields(@PathParam("id") String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @POST
    @Path("/characters")
    public Response createCharacter(Character c) {
        // TODO Auto-generated method stub
        return null;
    }
}
