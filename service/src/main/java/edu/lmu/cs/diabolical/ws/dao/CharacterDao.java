package edu.lmu.cs.diabolical.ws.dao;

import edu.lmu.cs.diabolical.ws.domain.Character;
import java.util.List;

public interface CharacterDao {
    public List<Character> getCharactersByQuery(String query);

    public Character getCharacterById(Integer id);

    public void deleteCharacter(Character c);

    public Character createOrUpdateCharacter(Character c);

    public Character createCharacter(Character c);
}
