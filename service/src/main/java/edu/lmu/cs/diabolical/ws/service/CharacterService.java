package edu.lmu.cs.diabolical.ws.service;

import edu.lmu.cs.diabolical.ws.domain.Character;

public interface CharacterService {

    public Character getCharacterById(Integer id);

    public Character createCharacter(Character character);

    public void createOrUpdateCharacter(Character character);

    public void deleteCharacter(Character character);
}
