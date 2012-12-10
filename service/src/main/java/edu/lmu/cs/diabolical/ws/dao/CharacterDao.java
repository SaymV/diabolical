package edu.lmu.cs.diabolical.ws.dao;

import edu.lmu.cs.diabolical.ws.domain.Character;
import edu.lmu.cs.diabolical.ws.domain.Gender;

import java.util.List;

public interface CharacterDao {
    public List<Character> getCharacters(String name, String className, Gender gender, Integer minLevel, Integer maxLevel);

    public Character getCharacterById(Integer id);

    public void deleteCharacter(Character c);

    public Character createOrUpdateCharacter(Character c);

    public Character createCharacter(Character c);
}
