package edu.lmu.cs.diabolical.ws.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.lmu.cs.diabolical.ws.domain.Character;
import edu.lmu.cs.diabolical.ws.domain.Gender;
import edu.lmu.cs.diabolical.ws.domain.Item;
import edu.lmu.cs.diabolical.ws.domain.Quest;
import edu.lmu.cs.diabolical.ws.domain.Skill;
import edu.lmu.cs.diabolical.ws.util.ApplicationContextTest;

public class CharacterDaoTest extends ApplicationContextTest {

    private CharacterDao charDao;

    @Before
    public void getRequiredBeans() {
        charDao = (CharacterDao) applicationContext.getBean("characterDao");
    }

    @Test
    public void createCharacterInDatabaseAndRetrieveById() {
        Character c = new Character("Crazy Uncle Rich", Gender.MALE, "Project Manager", 99, 1000000000L, new ArrayList<Item>(),
                new ArrayList<Skill>(), new ArrayList<Quest>());

        
        assertEquals(charDao.createCharacter(c).getName(), "Crazy Uncle Rich");
        assertEquals(charDao.getCharacterById(1).getId(), (Integer) 1);
    }

    @Test
    public void updateCharacterInDatabase() {
        Character c = new Character("Crazy Uncle Rich", Gender.MALE, "Project Manager", 99, 1000000000L, new ArrayList<Item>(),
                new ArrayList<Skill>(), new ArrayList<Quest>());

        
        assertEquals(charDao.createCharacter(c).getName(), "Crazy Uncle Rich");
        c.setName("Uncle Bob");
        charDao.createOrUpdateCharacter(c);
        assertEquals(charDao.getCharacterById(1).getName(), "Uncle Bob");
    }

    @Test
    public void deleteCharacterFromDatabase() {
        Character c = new Character("Crazy Uncle Rich", Gender.MALE, "Project Manager", 99, 1000000000L, new ArrayList<Item>(),
                new ArrayList<Skill>(), new ArrayList<Quest>());

        assertEquals(charDao.createCharacter(c).getId(), (Integer) 1);
        charDao.deleteCharacter(c);
        assertEquals(charDao.getCharacterById(1), null);
    }
}
