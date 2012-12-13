package edu.lmu.cs.diabolical.ws.resource;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
    public void getNonexistentCharacterReturns404() {
        ClientResponse clientResponse = wr.path("/characters/50123").get(ClientResponse.class);
        assertEquals(404, clientResponse.getStatus());
    }

    @Test
    public void getCharacterByNegativeIdReturns400() {
        ClientResponse clientResponse = wr.path("/characters/-1").get(ClientResponse.class);
        assertEquals(400, clientResponse.getStatus());
    }

    @Test
    public void getCharacterById0Returns400() {
        ClientResponse clientResponse = wr.path("/characters/0").get(ClientResponse.class);
        assertEquals(400, clientResponse.getStatus());
    }

    @Test
    public void queryCharactersWithoutParametersReturns400() {
        ClientResponse clientResponse = wr.path("/characters").get(ClientResponse.class);
        assertEquals(400, clientResponse.getStatus());
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

    @Test
    public void deleteCharacterWithNonexistentId() {
        ClientResponse clientResponse = wr.path("/characters/9867485").delete(ClientResponse.class);
        assertEquals(404, clientResponse.getStatus());
    }

    @Test
    public void deleteCharacterWithNegativeIdReturns400() {
        ClientResponse clientResponse = wr.path("/characters/-1").delete(ClientResponse.class);
        assertEquals(400, clientResponse.getStatus());
    }

    @Test
    public void deleteCharacterWithId0Returns400() {
        ClientResponse clientResponse = wr.path("/characters/0").delete(ClientResponse.class);
        assertEquals(400, clientResponse.getStatus());
    }

    @Test
    public void updateSpecificCharacterFields() {
        Character c = new Character("HonkyTonkers", Gender.MALE, "Priest", 15, 1000000000L, new ArrayList<Item>(),
                new ArrayList<Skill>(), new ArrayList<Quest>());

        ClientResponse clientResponse = wr.path("/characters").post(ClientResponse.class, c);
        assertEquals(201, clientResponse.getStatus());

        c = wr.path("/characters/1").get(new GenericType<Character>() {
        });

        c.setName("FunkyFlow");
        c.setGender(Gender.FEMALE);
        c.setMoney(null);

        c = wr.path("/characters/update").put(new GenericType<Character>() {
        }, c);
        assertEquals(c.getName(), "FunkyFlow");
        assertEquals(c.getGender(), Gender.FEMALE);
        assertEquals(c.getMoney(), (Long) 1000000000L);
    }

    @Test
    public void runCharactersQuery() {
        Character c = new Character("WonkyBonkers", Gender.FEMALE, "Rogue", 32, 1000000000L, new ArrayList<Item>(),
                new ArrayList<Skill>(), new ArrayList<Quest>());

        ClientResponse clientResponse = wr.path("/characters").post(ClientResponse.class, c);
        assertEquals(201, clientResponse.getStatus());

        List<Character> characters = wr.path("/characters").queryParam("name", "WonkyBonkers")
                .get(new GenericType<List<Character>>() {
                });
        assertEquals(characters.size(), 1);
    }

    @Test
    public void runCharacterQueryWithNoCharactersFound() {
        ClientResponse response = wr.path("/characters").queryParam("name", "stufusdljfnasdifnalsjkndf")
                .get(ClientResponse.class);
        assertEquals(response.getStatus(), 404);
    }

    @Test
    public void runCharacterQueryParamsReturns400() {
        ClientResponse response = wr.path("/characters").get(ClientResponse.class);
        assertEquals(response.getStatus(), 400);
    }

    @Test
    public void queryForCharactersByLevelRange() {
        Character c = new Character("HonkyTonkers", Gender.MALE, "Priest", 13, 1000000000L, new ArrayList<Item>(),
                new ArrayList<Skill>(), new ArrayList<Quest>());

        ClientResponse clientResponse = wr.path("/characters").post(ClientResponse.class, c);
        assertEquals(201, clientResponse.getStatus());

        List<Character> characters = wr.path("/characters").queryParam("minLevel", "10").queryParam("maxLevel", "14")
                .get(new GenericType<List<Character>>() {
                });
        assertEquals(characters.size(), 1);
        assertEquals(characters.get(0).getName(), "HonkyTonkers");
    }

    @Test
    public void queryForCharactersByName() {
        Character c = new Character("FunkyStuff", Gender.MALE, "Priest", 45, 1000000000L, new ArrayList<Item>(),
                new ArrayList<Skill>(), new ArrayList<Quest>());

        ClientResponse clientResponse = wr.path("/characters").post(ClientResponse.class, c);
        assertEquals(201, clientResponse.getStatus());

        List<Character> characters = wr.path("/characters").queryParam("name", "FunkyStuff")
                .get(new GenericType<List<Character>>() {
                });
        assertEquals(characters.size(), 1);
        assertEquals(characters.get(0).getName(), "FunkyStuff");
    }

    @Test
    public void queryForCharactersByClassName() {
        Character c = new Character("TreesNShit", Gender.MALE, "Druid", 63, 1000000000L, new ArrayList<Item>(),
                new ArrayList<Skill>(), new ArrayList<Quest>());

        ClientResponse clientResponse = wr.path("/characters").post(ClientResponse.class, c);
        assertEquals(201, clientResponse.getStatus());

        List<Character> characters = wr.path("/characters").queryParam("className", "Druid")
                .get(new GenericType<List<Character>>() {
                });
        assertEquals(characters.size(), 1);
        assertEquals(characters.get(0).getName(), "TreesNShit");
    }

    @Test
    public void queryForCharactersByGender() {
        Character c = new Character("NewcastleBrownAle", Gender.MALE, "Druid", 71, 1000000000L, new ArrayList<Item>(),
                new ArrayList<Skill>(), new ArrayList<Quest>());

        ClientResponse clientResponse = wr.path("/characters").post(ClientResponse.class, c);
        assertEquals(201, clientResponse.getStatus());

        List<Character> characters = wr.path("/characters").queryParam("gender", "MALE").queryParam("minLevel", "71")
                .queryParam("maxLevel", "71").get(new GenericType<List<Character>>() {
                });
        assertEquals(characters.size(), 1);
        assertEquals(characters.get(0).getName(), "NewcastleBrownAle");
    }

    @Test
    public void generateRandomCharacter() {
        ClientResponse clientResponse = wr.path("/characters/spawn").get(ClientResponse.class);
        assertEquals(200, clientResponse.getStatus());
    }
}
