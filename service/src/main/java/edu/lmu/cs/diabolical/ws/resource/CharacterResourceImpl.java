package edu.lmu.cs.diabolical.ws.resource;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import edu.lmu.cs.diabolical.ws.domain.Character;
import edu.lmu.cs.diabolical.ws.domain.Gender;
import edu.lmu.cs.diabolical.ws.service.CharacterService;

@Path("/characters")
public class CharacterResourceImpl extends AbstractResource implements CharacterResource {

    CharacterService characterService;

    public CharacterResourceImpl(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Override
    public Character getCharacterById(Integer id) {
        logServiceCall();

        validate((id != null && id > 0), Response.Status.BAD_REQUEST, INVALID_CHARACTER_ID);
        Character c = characterService.getCharacterById(id);
        validate(c != null, Response.Status.NOT_FOUND, CHARACTER_NOT_FOUND);

        return c;
    }

    @Override
    public List<Character> getCharactersByQuery(String name, String className, Gender gender, Integer minLevel,
            Integer maxLevel) {

        logServiceCall();

        List<Character> characters = characterService.getCharacters(name, className, gender, minLevel, maxLevel);
        validate(characters.size() > 0, Response.Status.NOT_FOUND, NO_CHARACTERS_FOUND_WITH_GIVEN_PARAMS);

        return characters;
    }

    @Override
    public Character spawnRandomCharacter() {
        logServiceCall();

        return characterService.spawnRandomCharacter();
    }

    @Override
    public Response deleteCharacterById(Integer id) {
        logServiceCall();

        validate((id != null && id > 0), Response.Status.BAD_REQUEST, INVALID_CHARACTER_ID);
        Character c = characterService.getCharacterById(id);
        validate(c != null, Response.Status.NOT_FOUND, CHARACTER_NOT_FOUND);

        characterService.deleteCharacter(c);

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @Override
    public Character updateCharacter(Character c) {
        logServiceCall();

        validate((c != null && c.getId() != null && c.getId() > 0), Response.Status.BAD_REQUEST, INVALID_CHARACTER_ID);
        Character character = characterService.getCharacterById(c.getId());
        validate(character != null, Response.Status.NOT_FOUND, CHARACTER_NOT_FOUND);
        character = characterService.createOrUpdateCharacter(c);

        return character;
    }

    @Override
    public Character updateCharacterByIdWithSpecifiedFields(Character c) {
        logServiceCall();

        validate((c != null && c.getId() != null && c.getId() > 0), Response.Status.BAD_REQUEST, INVALID_CHARACTER_ID);
        Character character = characterService.getCharacterById(c.getId());
        validate(character != null, Response.Status.NOT_FOUND, CHARACTER_NOT_FOUND);

        return characterService.updateCharacterWithGivenFields(c);
    }

    @Override
    public Response createCharacter(Character c) {
        logServiceCall();

        validate(c != null, Response.Status.BAD_REQUEST, CHARACTER_NOT_PROVIDED);
        c.setId(null);
        Character character = characterService.createCharacter(c);

        return Response.created(uriInfo.getAbsolutePathBuilder().path(character.getId().toString()).build()).build();
    }

}
