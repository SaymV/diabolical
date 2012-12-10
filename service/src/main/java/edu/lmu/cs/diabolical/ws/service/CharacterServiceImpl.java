package edu.lmu.cs.diabolical.ws.service;

import java.util.List;

import edu.lmu.cs.diabolical.ws.dao.CharacterDao;
import edu.lmu.cs.diabolical.ws.domain.Character;
import edu.lmu.cs.diabolical.ws.domain.Gender;

public class CharacterServiceImpl extends AbstractService implements CharacterService {

    CharacterDao characterDao;

    public CharacterServiceImpl(CharacterDao characterDao) {
        this.characterDao = characterDao;
    }

    @Override
    public List<Character> getCharacters(String name, String className, Gender gender, Integer minLevel, Integer maxLevel) {
        return characterDao.getCharacters(name, className, gender, minLevel, maxLevel);
    }
    
    @Override
    public Character getCharacterById(Integer id) {
        return characterDao.getCharacterById(id);
    }

    @Override
    public Character createOrUpdateCharacter(Character character) {
        return characterDao.createOrUpdateCharacter(character);
    }

    // TODO: Test this.
    @Override
    public Character updateCharacterWithGivenFields(Character character) {
        Character current = characterDao.getCharacterById(character.getId());

        if (character.getAccomplishedQuests() != null ) {
            current.setAccomplishedQuests(character.getAccomplishedQuests());
        }

        if (character.getClassType() != null) {
            current.setClassType(character.getClassType());
        }

        if (character.getGender() != null) {
            current.setGender(character.getGender());
        }

        if (character.getItems() != null) {
            current.setItems(character.getItems());
        }

        if (character.getLevel() != null) {
            current.setLevel(character.getLevel());
        }

        if (character.getMoney() != null) {
            current.setMoney(character.getMoney());
        }

        if (character.getName() != null) {
            current.setName(character.getName());
        }

        if (character.getSkills() != null) {
            current.setSkills(character.getSkills());
        }

        return characterDao.createOrUpdateCharacter(current);
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
