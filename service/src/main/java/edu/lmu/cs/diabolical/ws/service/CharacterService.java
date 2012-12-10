package edu.lmu.cs.diabolical.ws.service;

import java.util.List;

import edu.lmu.cs.diabolical.ws.domain.Character;
import edu.lmu.cs.diabolical.ws.domain.Gender;

public interface CharacterService {

    public List<Character> getCharacters(String name, String className, Gender gender, Integer minLevel, Integer maxLevel);
    
    public Character getCharacterById(Integer id);

    public Character createCharacter(Character character);

    public Character createOrUpdateCharacter(Character character);

    public void deleteCharacter(Character character);
}
