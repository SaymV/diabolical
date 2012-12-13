package edu.lmu.cs.diabolical.ws.resource;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import edu.lmu.cs.diabolical.ws.domain.Character;
import edu.lmu.cs.diabolical.ws.domain.Gender;
import edu.lmu.cs.diabolical.ws.service.CharacterService;

@Path("/characters")
public class CharacterResourceImpl extends AbstractResource implements CharacterResource {

    private static final String INVALID_CHARACTER_ID = "Character ID invalid or missing.";
    private static final String CHARACTER_NOT_PROVIDED = "No character object payload provided.";
    private static final String CHARACTER_NOT_FOUND = "Character not found.";

    CharacterService characterService;

    public CharacterResourceImpl(CharacterService characterService) {
        this.characterService = characterService;
    }

    // Tested
    @Override
    public Character getCharacterById(Integer id) {
        logServiceCall();

        validate((id != null && id > 0), Response.Status.BAD_REQUEST, INVALID_CHARACTER_ID);
        Character c = characterService.getCharacterById(id);
        validate(c != null, Response.Status.NOT_FOUND, CHARACTER_NOT_FOUND);

        return c;
    }

    // Tested
    @Override
    public List<Character> getCharactersByQuery(String name, String className, Gender gender, Integer minLevel, Integer maxLevel) {

        logServiceCall();

        return characterService.getCharacters(name, className, gender, minLevel, maxLevel);
    }

    // Tested
    @Override
    public Character spawnRandomCharacter() {
        logServiceCall();

        return characterService.spawnRandomCharacter();
    }

    // Tested
    @Override
    public Response deleteCharacterById(Integer id) {
        logServiceCall();

        validate((id != null && id >= 0), Response.Status.BAD_REQUEST, INVALID_CHARACTER_ID);

        characterService.deleteCharacter(characterService.getCharacterById(id));

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    // Tested
    @Override
    public Character updateCharacter(Character c) {
        logServiceCall();

        validate(c != null, Response.Status.BAD_REQUEST, CHARACTER_NOT_PROVIDED);

        return characterService.createOrUpdateCharacter(c);
    }

    // Tested
    @Override
    public Character updateCharacterByIdWithSpecifiedFields(Character c) {
        logServiceCall();
        
        validate((c != null && c.getId() != null && c.getId() >= 0), Response.Status.BAD_REQUEST, INVALID_CHARACTER_ID);
        
        return characterService.updateCharacterWithGivenFields(c);
    }

    // Tested
    @Override
    public Response createCharacter(Character c) {
        logServiceCall();

        validate(c != null, Response.Status.BAD_REQUEST, CHARACTER_NOT_PROVIDED);

        Character character = characterService.createCharacter(c);

        return Response.created(uriInfo.getAbsolutePathBuilder().path(character.getId() + "").build()).build();
    }
}
