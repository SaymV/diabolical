package edu.lmu.cs.diabolical.ws.resource;

import org.junit.Assert;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;

import edu.lmu.cs.diabolical.ws.domain.Account;

public class AccountResourceTest extends ResourceTest{
    
    @Test
    public void testGetNonExistantAccountById() {
        ClientResponse response = wr.path("accounts/32").get(ClientResponse.class);
        Assert.assertEquals(404, response.getStatus());
    }

    @Test
    public void testGetAccountById() {
        Account account = wr.path("accounts/100001").get(ClientResponse.class).getEntity(Account.class);
        Assert.assertEquals(account.getId(), Long.valueOf(100001L));
        Assert.assertEquals(account.getFirstName(), "Jose");
        Assert.assertEquals(account.getLastName(), "Jose");
        Assert.assertEquals(account.getLogin(), "upswimsdn");
        Assert.assertEquals(account.getPassword(), "aaaaaa");
    }
}
