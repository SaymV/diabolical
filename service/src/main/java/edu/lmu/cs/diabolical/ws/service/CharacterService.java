package edu.lmu.cs.diabolical.ws.service;

import java.util.List;

import edu.lmu.cs.diabolical.ws.domain.Character;
import edu.lmu.cs.diabolical.ws.domain.Gender;

public interface CharacterService {

    List<Character> getCharacters(String name, String className, Gender gender, Integer minLevel, Integer maxLevel);
    
    Character getCharacterById(Integer id);

    Character createCharacter(Character character);

    Character spawnRandomCharacter();

    Character createOrUpdateCharacter(Character character);

    Character updateCharacterWithGivenFields(Character character);

    void deleteCharacter(Character character);
}
