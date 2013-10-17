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

    @Override
    public List<Character> getCharacters(String name, String className, Gender gender, Integer minLevel, Integer maxLevel) {
        return characterDao.getCharacters(name, className, gender, minLevel, maxLevel);
    }

    @Override
    public Character getCharacterById(Long id) {
        return characterDao.getCharacterById(id);
    }

    @Override
    public Character spawnRandomCharacter() {
        Random gen = new Random();
        return new Character(randomString(gen.nextInt(15) + 1),
                (gen.nextInt() % 2 == 1 ? Gender.MALE : Gender.FEMALE),
                randomString(gen.nextInt(15) + 1),
                new Long(gen.nextInt(99) + 1),
                new Long(gen.nextInt(100000000)),
                new ArrayList<Item>(), new ArrayList<Skill>(), new ArrayList<Quest>());
    }

    @Override
    public void updateCharacter(Character character) {
        characterDao.updateCharacter(character);
    }

    @Override
    public Character createCharacter(Character character) {
        return characterDao.createCharacter(character);
    }

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
