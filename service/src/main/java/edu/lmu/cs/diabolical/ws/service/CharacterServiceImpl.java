package edu.lmu.cs.diabolical.ws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.lmu.cs.diabolical.ws.dao.CharacterDao;
//import edu.lmu.cs.diabolical.ws.dao.CharacterDao;
import edu.lmu.cs.diabolical.ws.domain.Character;
import edu.lmu.cs.diabolical.ws.domain.Gender;
import edu.lmu.cs.diabolical.ws.domain.Item;
import edu.lmu.cs.diabolical.ws.domain.Quest;
import edu.lmu.cs.diabolical.ws.domain.Skill;

public class CharacterServiceImpl extends AbstractService implements CharacterService {

    CharacterDao characterDao;

    public CharacterServiceImpl(CharacterDao characterDao) {
        this.characterDao = characterDao;
    }

    // Tested
    @Override
    public List<Character> getCharacters(String name, String className, Gender gender, Integer minLevel,
            Integer maxLevel) {
        return characterDao.getCharacters(name, className, gender, minLevel, maxLevel);
    }

    // Tested
    @Override
    public Character getCharacterById(Integer id) {
        return characterDao.getCharacterById(id);
    }

    // TODO: Test this
    @Override
    public Character spawnRandomCharacter() {
        Random gen = new Random();
        return /*characterDao.createCharacter(*/new Character(
                randomString(gen.nextInt(15) + 1),
                (gen.nextInt() % 2 == 1 ? Gender.MALE : Gender.FEMALE),
                randomString(gen.nextInt(15) + 1),
                (Integer) (gen.nextInt(99) + 1),
                new Long(gen.nextInt(100000000)),
                new ArrayList<Item>(), new ArrayList<Skill>(), new ArrayList<Quest>())/*)*/;
    }

    // Tested
    @Override
    public Character createOrUpdateCharacter(Character character) {
        return characterDao.createOrUpdateCharacter(character);
    }

    // Tested
    @Override
    public Character updateCharacterWithGivenFields(Character character) {
        Character current = characterDao.getCharacterById(character.getId());

        if (character.getAccomplishedQuests() != null) {
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

    // Tested
    @Override
    public Character createCharacter(Character character) {
        return characterDao.createCharacter(character);
    }

    // Tested
    @Override
    public void deleteCharacter(Character character) {
        characterDao.deleteCharacter(character);
    }

    private static String randomString(int length) {
        Random generator = new Random();
        String characters = "ABCDEFGHIZKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(generator.nextInt(characters.length()));
        }
        return new String(text);
    }
}
