package edu.lmu.cs.diabolical.ws.service;

public interface CharacterService {

    public Character getCharacterById(Long id);

    public Character getCharacterByName(String name);

    public Character createCharacter(Character character);

    public void createOrUpdateCharacter(Character character);
}
