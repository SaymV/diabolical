package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

public interface CharacterDao {
    public List<Character> getCharactersByQuery(String query);
    
    public Character getCharacterById(Integer id);
    
    public void deleteCharacter(Character c);

    public void createOrUpdateCharacter(Character c);
    
    public Character createCharacter(Character c);
}
