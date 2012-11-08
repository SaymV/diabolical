package edu.lmu.cs.diabolical.ws.domain;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UserTest {
    
    List<Account> sampleAccounts= new ArrayList<Account>();
    
    @Test
    public void testUserConstructors() {
        User u = new User(20, "upswimsdn", Gender.MALE, sampleAccounts);
        assertThat(u.getId(), is(20));
        assertThat(u.getUsername(), is("upswimsdn"));
        assertThat(u.getGender(), is(Gender.MALE));
        assertThat(u.getAccounts(), is(sampleAccounts));
    }

}
