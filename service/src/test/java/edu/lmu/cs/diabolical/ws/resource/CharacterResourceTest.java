package edu.lmu.cs.diabolical.ws.resource;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

import edu.lmu.cs.diabolical.ws.domain.Character;
import edu.lmu.cs.diabolical.ws.domain.Gender;
import edu.lmu.cs.diabolical.ws.domain.Item;
import edu.lmu.cs.diabolical.ws.domain.Quest;
import edu.lmu.cs.diabolical.ws.domain.Skill;

public class CharacterResourceTest extends ResourceTest {
    @Test
    public void createAndGetCharacter() {
        Character c = new Character("Crazy Uncle Rich", Gender.MALE, "Project Manager", 99, 1000000000L,
                new ArrayList<Item>(), new ArrayList<Skill>(), new ArrayList<Quest>());

        ClientResponse clientResponse = wr.path("/characters").post(ClientResponse.class, c);
        assertEquals(201, clientResponse.getStatus());

        clientResponse = wr.path("/characters/1").get(ClientResponse.class);
        c = wr.path("/characters/1").get(new GenericType<Character>() {
        });
        assertEquals(200, clientResponse.getStatus());
        assertEquals("Crazy Uncle Rich", c.getName());
    }

    @Test
    public void updateAndDeleteCharacter() {
        Character c = new Character("Crazy Uncle Rich", Gender.MALE, "Project Manager", 99, 1000000000L,
                new ArrayList<Item>(), new ArrayList<Skill>(), new ArrayList<Quest>());

        ClientResponse clientResponse = wr.path("/characters").post(ClientResponse.class, c);
        assertEquals(201, clientResponse.getStatus());

        c.setName("HardyHar");
        clientResponse = wr.path("/characters").put(ClientResponse.class, c);
        assertEquals(200, clientResponse.getStatus());
        c = wr.path("/characters/2").get(new GenericType<Character>() {
        });
        assertEquals("HardyHar", c.getName());

        clientResponse = wr.path("/characters/2").delete(ClientResponse.class);
        assertEquals(204, clientResponse.getStatus());
    }

    @Ignore
    @Test
    public void runCharactersQuery() {
        Character c = new Character("WonkyBonkers", Gender.FEMALE, "Rogue", 32, 1000000000L,
                new ArrayList<Item>(), new ArrayList<Skill>(), new ArrayList<Quest>());

        ClientResponse clientResponse = wr.path("/characters").post(ClientResponse.class, c);
        assertEquals(201, clientResponse.getStatus());

        List<Character> characters = wr.path("/characters").queryParam("name", "WonkyBonkers").get(new GenericType<List<Character>>() {
        });
        assertEquals(characters.size(), 1);
    }

    @Test
    public void updateSpecificCharacterFields() {
        Character c = new Character("HonkyTonkers", Gender.MALE, "Priest", 15, 1000000000L,
                new ArrayList<Item>(), new ArrayList<Skill>(), new ArrayList<Quest>());

        ClientResponse clientResponse = wr.path("/characters").post(ClientResponse.class, c);
        assertEquals(201, clientResponse.getStatus());

        c = wr.path("/characters/1").get(new GenericType<Character>() {
        });
        
        c.setName("FunkyFlow");
        c.setGender(Gender.FEMALE);
        c.setMoney(null);
        
        c = wr.path("/characters/update").put(new GenericType<Character>(){}, c);
        assertEquals(c.getName(), "FunkyFlow");
        assertEquals(c.getGender(), Gender.FEMALE);
        assertEquals(c.getMoney(), (Long) 1000000000L);
    }

    @Test
    public void queryForCharacters() {
        Character c = new Character("HonkyTonkers", Gender.MALE, "Priest", 13, 1000000000L,
                new ArrayList<Item>(), new ArrayList<Skill>(), new ArrayList<Quest>());

        ClientResponse clientResponse = wr.path("/characters").post(ClientResponse.class, c);
        assertEquals(201, clientResponse.getStatus());
        
        List<Character> characters = wr.path("/characters").queryParam("minLevel", "10").queryParam("maxLevel", "14").get(new GenericType<List<Character>>(){});
        assertEquals(characters.size(), 1);
    }
}
