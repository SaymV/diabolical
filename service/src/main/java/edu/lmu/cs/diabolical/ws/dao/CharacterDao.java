package edu.lmu.cs.diabolical.ws.dao;

import edu.lmu.cs.diabolical.ws.domain.Character;
import edu.lmu.cs.diabolical.ws.domain.Gender;

import java.util.List;

public interface CharacterDao {
    List<Character> getCharacters(String name, String className, Gender gender, Integer minLevel, Integer maxLevel);

    Character getCharacterById(Integer id);

    void deleteCharacter(Character c);

    Character createOrUpdateCharacter(Character c);

    Character createCharacter(Character c);
}
