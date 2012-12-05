package edu.lmu.cs.diabolical.ws.service;

import edu.lmu.cs.diabolical.ws.dao.CharacterDao;
import edu.lmu.cs.diabolical.ws.domain.Character;

public class CharacterServiceImpl extends AbstractService implements CharacterService {

    CharacterDao characterDao;

    public CharacterServiceImpl(CharacterDao characterDao) {
        this.characterDao = characterDao;
    }

    @Override
    public Character getCharacterById(Integer id) {
        return characterDao.getCharacterById(id);
    }

    @Override
    public void createOrUpdateCharacter(Character character) {
        characterDao.createOrUpdateCharacter(character);
    }

    @Override
    public Character createCharacter(Character character) {
        return characterDao.createCharacter(character);
    }

    @Override
    public void deleteCharacter(Character character) {
        characterDao.deleteCharacter(character);
    }

}
