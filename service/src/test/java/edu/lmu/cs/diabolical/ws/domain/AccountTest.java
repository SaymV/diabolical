package edu.lmu.cs.diabolical.ws.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AccountTest {

    @Test
    public void testAccountConstructor() {
        Account a = new Account(23, "myname", "ABCDEFG123", new ArrayList<Character>());
        assertThat(a.getId(), is(23));
        assertThat(a.getLogin(), is("myname"));
        assertThat(a.getPassword(), is("ABCDEFG123"));
        assertThat(a.getCharacters().size(), is(0));
    }
    
    @Test
    public void testAccountSetterMethods() {
        Account a = new Account(23, "myname", "ABCDEFG123", new ArrayList<Character>());
        List <Character> characters = new ArrayList<Character>();
        characters.add(new Character());
        a.setId(55);
        a.setLogin("Badonk");
        a.setPassword("HELLO");
        a.setCharacters(characters);
        assertThat(a.getId(), is(55));
        assertThat(a.getLogin(), is("Badonk"));
        assertThat(a.getPassword(), is("HELLO"));
        assertThat(a.getCharacters().size(), is(1));
    }
}
