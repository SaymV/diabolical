package edu.lmu.cs.diabolical.ws.resource;

import java.util.List;

import javax.ws.rs.core.Response;

import edu.lmu.cs.diabolical.ws.domain.Character;
import edu.lmu.cs.diabolical.ws.service.CharacterService;

public class CharacterResourceImpl extends AbstractResource implements CharacterResource {

    private static final String INVALID_CHARACTER_ID = "Character ID invalid or missing.";
    private static final String CHARACTER_QUERY_PARAMS_MISSING = "Character query parameter missing.";
    private static final String CHARACTER_NOT_PROVIDED = "No character object payload provided.";
    
    CharacterService characterService;

    public CharacterResourceImpl(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Override
    public Character getCharacterById(Integer id) {
        logServiceCall();

        validate((id != null && id >= 0), Response.Status.BAD_REQUEST, INVALID_CHARACTER_ID);

        return characterService.getCharacterById(id);
    }

    // TODO: Finish this.
    @Override
    public List<Character> getCharactersByQuery(String q) {

        logServiceCall();

        validate(q != null, Response.Status.BAD_REQUEST, CHARACTER_QUERY_PARAMS_MISSING);

//        return characterService.getCharacters(preprocessNullableQuery(query, skip, max, 0, 100), minlevel, maxlevel,
//                skip, max);
        return null;
    }

    @Override
    public Character spawnRandomCharacter() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response deleteCharacterById(Integer id) {
        logServiceCall();

        validate((id != null && id >= 0), Response.Status.BAD_REQUEST, INVALID_CHARACTER_ID);

        characterService.deleteCharacter(characterService.getCharacterById(id));

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @Override
    public Character updateCharacter(Character c) {
        logServiceCall();
        
        validate(c != null, Response.Status.BAD_REQUEST, CHARACTER_NOT_PROVIDED);
        
        return characterService.createOrUpdateCharacter(c);
    }

    @Override
    public Character updateCharacterByIdWithSpecifiedFields(Character c) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response createCharacter(Character c) {
        logServiceCall();
        
        validate(c != null, Response.Status.BAD_REQUEST, CHARACTER_NOT_PROVIDED);

        characterService.createCharacter(c);
        
        return Response.status(Response.Status.CREATED).build();
    }
}
