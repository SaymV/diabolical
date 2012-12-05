package edu.lmu.cs.diabolical.ws.service;

import edu.lmu.cs.diabolical.ws.dao.CharacterDao;

public class CharacterServiceImpl extends AbstractService implements CharacterService {

    CharacterDao characterDao;

    public CharacterServiceImpl(CharacterDao characterDao) {
        this.characterDao = characterDao;
    }

    @Override
    public Character getCharacterById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createOrUpdateCharacter(Character character) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Character getCharacterByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Character createCharacter(Character character) {
        // TODO Auto-generated method stub
        return null;
    }


}
