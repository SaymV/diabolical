package edu.lmu.cs.diabolical.ws.service;

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

public class CharacterServiceTest extends ApplicationContextTest {

    private CharacterService charService;

    @Before
    public void getRequiredBeans() {
        charService = (CharacterService) applicationContext.getBean("characterService");
    }

    @Test
    public void createCharacterAndRetrieveById() {
        Character c = new Character("Crazy Uncle Rich", Gender.MALE, "Project Manager", 99, 1000000000L, new ArrayList<Item>(),
                new ArrayList<Skill>(), new ArrayList<Quest>());

        
        assertEquals(charService.createCharacter(c).getName(), "Crazy Uncle Rich");
        assertEquals(charService.getCharacterById(1).getId(), (Integer) 1);
    }

    @Test
    public void updateCharacter() {
        Character c = new Character("Crazy Uncle Rich", Gender.MALE, "Project Manager", 99, 1000000000L, new ArrayList<Item>(),
                new ArrayList<Skill>(), new ArrayList<Quest>());

        
        assertEquals(charService.createCharacter(c).getName(), "Crazy Uncle Rich");
        c.setName("Uncle Bob");
        charService.createOrUpdateCharacter(c);
        assertEquals(charService.getCharacterById(1).getName(), "Uncle Bob");
    }

    @Test
    public void deleteCharacter() {
        Character c = new Character("Crazy Uncle Rich", Gender.MALE, "Project Manager", 99, 1000000000L, new ArrayList<Item>(),
                new ArrayList<Skill>(), new ArrayList<Quest>());

        assertEquals(charService.createCharacter(c).getId(), (Integer) 1);
        charService.deleteCharacter(c);
        assertEquals(charService.getCharacterById(1), null);
    }
}
