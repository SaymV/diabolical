package edu.lmu.cs.diabolical.ws.resource;

import edu.lmu.cs.diabolical.ws.service.CharacterService;

public class CharacterResourceImpl extends AbstractResource implements CharacterResource {

    CharacterService characterService;

    public CharacterResourceImpl(CharacterService characterService) {
        this.characterService = characterService;
    }
}
