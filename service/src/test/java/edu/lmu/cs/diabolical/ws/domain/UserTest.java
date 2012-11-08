package edu.lmu.cs.diabolical.ws.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UserTest {

    List<Account> sampleAccounts = new ArrayList<Account>();

    @Test
    public void testUserConstructors() {
        User u = new User(20, "upswimsdn", Gender.MALE, sampleAccounts);
        assertThat(u.getId(), is(20));
        assertThat(u.getUsername(), is("upswimsdn"));
        assertThat(u.getGender(), is(Gender.MALE));
        assertThat(u.getAccounts(), is(sampleAccounts));
    }

    @Test
    public void testUserSetters() {
        User u = new User(20, "upswimsdn", Gender.MALE, sampleAccounts);
        List<Account> newAccounts = new ArrayList<Account>();
        newAccounts.add(new Account());
        u.setId(55);
        u.setGender(Gender.FEMALE);
        u.setUsername("nope");
        u.setAccounts(newAccounts);
        assertThat(u.getId(), is(55));
        assertThat(u.getGender(), is(Gender.FEMALE));
        assertThat(u.getUsername(), is("nope"));
        assertThat(u.getAccounts().size(), is(1));
    }

}
