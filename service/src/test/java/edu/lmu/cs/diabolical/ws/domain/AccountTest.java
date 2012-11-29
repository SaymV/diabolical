package edu.lmu.cs.diabolical.ws.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {

    List<Character> sampleCharacterRoster;
    Character sampleCharacter = new Character(99, "Hodor", Gender.MALE, null, null, null, null, null, null);
    Account sampleAccount;

    @Before
    public void setUp() {
        sampleCharacterRoster = new ArrayList<Character>();
        sampleAccount = new Account(1L, "Oli Oli Oxen Free", "YUP", sampleCharacterRoster);
    }

    @Test
    public void testAccountConstructor() {
        Account a = new Account(23L, "myname", "ABCDEFG123", new ArrayList<Character>());
        assertThat(a.getId(), is(23L));
        assertThat(a.getLogin(), is("myname"));
        assertThat(a.getPassword(), is("ABCDEFG123"));
        assertThat(a.getCharacters().size(), is(0));
    }

    @Test
    public void testAccountSetterMethods() {
        Account a = new Account(23L, "myname", "ABCDEFG123", new ArrayList<Character>());
        List<Character> characters = new ArrayList<Character>();
        characters.add(new Character());
        assertThat(a.getId(), is(23L));
        a.setId(55L);
        assertThat(a.getId(), is(55L));
        assertThat(a.getLogin(), is("myname"));
        a.setLogin("Badonk");
        assertThat(a.getLogin(), is("Badonk"));
        assertThat(a.getPassword(), is("ABCDEFG123"));
        a.setPassword("HELLO");
        assertThat(a.getPassword(), is("HELLO"));
        assertThat(a.getCharacters().size(), is(0));
        a.setCharacters(characters);
        assertThat(a.getCharacters().size(), is(1));
    }

    @Test
    public void addCharacterIncrementsSizeOfCharacterList() {
        int initialCount = sampleAccount.getCharacters().size();
        sampleAccount.addCharacter(new Character());
        assertThat(sampleAccount.getCharacters().size(), is(initialCount + 1));
    }

    @Test
    public void addedCharacterCanBeRetrieved() {
        sampleAccount.addCharacter(sampleCharacter);
        Character retrievedHero = sampleAccount.getCharacters().get(0);
        assertThat(retrievedHero.getId(), is(sampleCharacter.getId()));
        assertThat(retrievedHero.getName(), is(sampleCharacter.getName()));
        assertThat(retrievedHero.getGender(), is(sampleCharacter.getGender()));
    }
}
