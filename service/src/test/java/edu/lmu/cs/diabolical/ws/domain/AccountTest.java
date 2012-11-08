package edu.lmu.cs.diabolical.ws.domain;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
}
