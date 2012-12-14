package edu.lmu.cs.diabolical.ws.resource;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

import edu.lmu.cs.diabolical.ws.domain.Account;
import edu.lmu.cs.diabolical.ws.domain.Gender;

public class AccountResourceTest extends ResourceTest {

    Account sampleAccount = new Account(null, "turd", "ferguson", "tf", "aaaaaa", null, Gender.MALE);

    @Test
    public void testGetNonExistantAccountById() {
        ClientResponse response = wr.path("accounts/32").get(ClientResponse.class);
        Assert.assertEquals(404, response.getStatus());
    }

    @Test
    public void getAccountById() {
        Account account = wr.path("accounts/100001").get(ClientResponse.class).getEntity(Account.class);
        Assert.assertEquals(account.getId(), Long.valueOf(100001L));
        Assert.assertEquals(account.getFirstName(), "Jose");
        Assert.assertEquals(account.getLastName(), "Jose");
        Assert.assertEquals(account.getLogin(), "upswimsdn");
        Assert.assertEquals(account.getPassword(), "aaaaaa");
    }

    @Test
    public void deleteAccountWithBadIdResponds404() {
        ClientResponse response = wr.path("accounts/aslkgj").delete(ClientResponse.class);
        Assert.assertEquals(404, response.getStatus());
    }

    @Test
    public void deleteAccountWithNonExistentAccountIdRespons404() {
        ClientResponse response = wr.path("accounts/26265").delete(ClientResponse.class);
        Assert.assertEquals(404, response.getStatus());
    }

    @Test
    public void deleteAccountResponds204() {
        ClientResponse response = wr.path("accounts/100001").delete(ClientResponse.class);
        Assert.assertEquals(204, response.getStatus());
    }

    @Test
    public void deletedAccountCanBeNoLongerBeFound() {
        ClientResponse response = wr.path("accounts/100001").delete(ClientResponse.class);
        Assert.assertEquals(204, response.getStatus());
        ClientResponse response2 = wr.path("accounts/100001").get(ClientResponse.class);
        Assert.assertEquals(404, response2.getStatus());
    }

    @Test
    public void createdAccountRespondsWithNewLocation() {
        ClientResponse response = wr.path("accounts").post(ClientResponse.class, sampleAccount);
        Assert.assertEquals(201, response.getStatus());
    }

    @Test
    public void createAccountWithIdNotNullResponds400() {
        sampleAccount.setId(Long.valueOf(56));
        ClientResponse response = wr.path("accounts").post(ClientResponse.class, sampleAccount);
        Assert.assertEquals(400, response.getStatus());
    }

    @Test
    public void createdAccountCanBeFound() {
        ClientResponse response = wr.path("accounts").post(ClientResponse.class, sampleAccount);
        Assert.assertEquals(201, response.getStatus());
        Account account = wr.path("accounts/1").get(Account.class);
        Assert.assertEquals(sampleAccount.getLogin(), account.getLogin());
        Assert.assertEquals(sampleAccount.getFirstName(), account.getFirstName());
        Assert.assertEquals(sampleAccount.getLastName(), account.getLastName());
        Assert.assertEquals(sampleAccount.getGender(), account.getGender());
    }

    @Test
    public void updateAccountResponds204() {
        Account account = wr.path("accounts/100001").get(ClientResponse.class).getEntity(Account.class);
        ClientResponse response = wr.path("accounts/100001").put(ClientResponse.class, account);
        Assert.assertEquals(204, response.getStatus());
    }

    @Test
    public void updatesToAccountCanBeRead() {
        Account account = wr.path("accounts/100001").get(ClientResponse.class).getEntity(Account.class);
        account.setLogin("yodello");
        wr.path("accounts/100001").put(ClientResponse.class, account);
        Account accountAfterUpdate = wr.path("accounts/100001").get(ClientResponse.class).getEntity(Account.class);
        Assert.assertEquals(account.getLogin(), accountAfterUpdate.getLogin());
        Assert.assertEquals(account.getFirstName(), accountAfterUpdate.getFirstName());
        Assert.assertEquals(account.getLastName(), accountAfterUpdate.getLastName());
        Assert.assertEquals(account.getGender(), accountAfterUpdate.getGender());
        Assert.assertEquals(account.getId(), accountAfterUpdate.getId());
    }

    @Test
    public void updateAccountWithMismatchedIdResponsd400() {
        Account account = new Account(Long.valueOf(50l), "first", "last", "login", "pw", null, Gender.MALE);
        ClientResponse response = wr.path("accounts/100001").put(ClientResponse.class, account);
        Assert.assertEquals(400, response.getStatus());
    }

    @Test
    public void endpointGetAccountsWithNoQueryResponds400() {
        ClientResponse response = wr.path("accounts").get(ClientResponse.class);
        Assert.assertEquals(400, response.getStatus());
    }

    @Test
    public void getAccountsWithBadPageSizeResponds400() {
        ClientResponse response = wr.path("accounts").queryParam("username", "ups").get(ClientResponse.class);
        Assert.assertEquals(200, response.getStatus());

        response = wr.path("accounts")
                .queryParam("username", "test")
                .queryParam("pageSize", "51")
                .get(ClientResponse.class);
        Assert.assertEquals(400, response.getStatus());
    }

    @Test
    public void getAccountswithBadPageNumberResponds400() {
        ClientResponse response = wr.path("accounts").queryParam("username", "ups").get(ClientResponse.class);
        Assert.assertEquals(200, response.getStatus());

        response = wr.path("accounts")
                .queryParam("username", "test")
                .queryParam("page", "-5")
                .get(ClientResponse.class);
        Assert.assertEquals(400, response.getStatus());
    }

    @Test
    public void getAccountsByGender() {
        List<Account> accounts = wr.path("accounts").queryParam("gender", "MALE").get(new GenericType<List<Account>>() {
        });
        Assert.assertEquals(2, accounts.size());
        Assert.assertEquals(Long.valueOf(100001L), accounts.get(0).getId());
        Assert.assertEquals("Jose", accounts.get(0).getFirstName());
        Assert.assertEquals("Jose", accounts.get(0).getLastName());
        Assert.assertEquals("upswimsdn", accounts.get(0).getLogin());
        Assert.assertEquals("aaaaaa", accounts.get(0).getPassword());
        Assert.assertEquals(Long.valueOf(100002L), accounts.get(1).getId());
        Assert.assertEquals("Ignatius", accounts.get(1).getFirstName());
        Assert.assertEquals("Lion", accounts.get(1).getLastName());
        Assert.assertEquals("lmulion", accounts.get(1).getLogin());
        Assert.assertEquals("iggy", accounts.get(1).getPassword());
    }

    @Test
    public void getAccountsByUsername() {
        List<Account> accounts = wr.path("accounts")
                .queryParam("username", "upsw")
                .get(new GenericType<List<Account>>() {
                });
        Assert.assertEquals(1, accounts.size());
        Assert.assertEquals("upswimsdn", accounts.get(0).getLogin());
        Assert.assertEquals(Long.valueOf(100001), accounts.get(0).getId());
        Assert.assertEquals("Jose", accounts.get(0).getFirstName());
        Assert.assertEquals("Jose", accounts.get(0).getLastName());
    }

    @Test
    public void getAcountsByUserNameAndGender() {
        List<Account> accounts = wr.path("accounts")
                .queryParam("username", "upsw")
                .queryParam("gender", "FEMALE")
                .get(new GenericType<List<Account>>() {
                });
        Assert.assertEquals(0, accounts.size());

        accounts = wr.path("accounts")
                .queryParam("username", "upsw")
                .queryParam("gender", "MALE")
                .get(new GenericType<List<Account>>() {
                });
        Assert.assertEquals(1, accounts.size());
        Assert.assertEquals("upswimsdn", accounts.get(0).getLogin());
        Assert.assertEquals(Long.valueOf(100001), accounts.get(0).getId());
        Assert.assertEquals("Jose", accounts.get(0).getFirstName());
        Assert.assertEquals("Jose", accounts.get(0).getLastName());
    }

    @Test
    public void getAccountsByFirstName() {
        List<Account> accounts = wr.path("accounts").queryParam("firstname", "J").get(new GenericType<List<Account>>() {
        });
        Assert.assertEquals(1, accounts.size());
        Assert.assertEquals("upswimsdn", accounts.get(0).getLogin());
        Assert.assertEquals(Long.valueOf(100001), accounts.get(0).getId());
        Assert.assertEquals("Jose", accounts.get(0).getFirstName());
        Assert.assertEquals("Jose", accounts.get(0).getLastName());
    }

    @Test
    public void getAccountsbyLastName() {
        List<Account> accounts = wr.path("accounts").queryParam("lastname", "lI").get(new GenericType<List<Account>>() {
        });
        Assert.assertEquals(1, accounts.size());
        Assert.assertEquals("lmulion", accounts.get(0).getLogin());
        Assert.assertEquals(Long.valueOf(100002), accounts.get(0).getId());
        Assert.assertEquals("Ignatius", accounts.get(0).getFirstName());
        Assert.assertEquals("Lion", accounts.get(0).getLastName());
    }

    @Test
    public void getAccountsByFirstAndLastName() {
        List<Account> accounts = wr.path("accounts")
                .queryParam("firstname", "i")
                .queryParam("lastname", "j")
                .get(new GenericType<List<Account>>() {
                });
        Assert.assertEquals(1, accounts.size());
        Assert.assertEquals("iz", accounts.get(0).getLogin());
        Assert.assertEquals(Long.valueOf(100004), accounts.get(0).getId());
        Assert.assertEquals("Isabelle", accounts.get(0).getFirstName());
        Assert.assertEquals("Johnson", accounts.get(0).getLastName());
    }

    @Test
    public void getAccountsByFullNameAndGender() {
        List<Account> accounts = wr.path("accounts")
                .queryParam("firstname", "i")
                .queryParam("lastname", "j")
                .queryParam("gender", "MALE")
                .get(new GenericType<List<Account>>() {
                });
        Assert.assertEquals(0, accounts.size());

        accounts = wr.path("accounts")
                .queryParam("firstname", "i")
                .queryParam("lastname", "j")
                .queryParam("gender", "FEMALE")
                .get(new GenericType<List<Account>>() {
                });
        Assert.assertEquals(1, accounts.size());
        Assert.assertEquals("iz", accounts.get(0).getLogin());
        Assert.assertEquals(Long.valueOf(100004), accounts.get(0).getId());
        Assert.assertEquals("Isabelle", accounts.get(0).getFirstName());
        Assert.assertEquals("Johnson", accounts.get(0).getLastName());
    }

    @Test
    public void getAccountsByFullNameGenderAndLogin() {
        List<Account> accounts = wr.path("accounts")
                .queryParam("firstname", "i")
                .queryParam("lastname", "j")
                .queryParam("gender", "FEMALE")
                .queryParam("username", "blue")
                .get(new GenericType<List<Account>>() {
                });
        Assert.assertEquals(0, accounts.size());

        accounts = wr.path("accounts")
                .queryParam("firstname", "i")
                .queryParam("lastname", "j")
                .queryParam("username", "i")
                .queryParam("gender", "FEMALE")
                .get(new GenericType<List<Account>>() {
                });
        Assert.assertEquals(1, accounts.size());
        Assert.assertEquals("iz", accounts.get(0).getLogin());
        Assert.assertEquals(Long.valueOf(100004), accounts.get(0).getId());
        Assert.assertEquals("Isabelle", accounts.get(0).getFirstName());
        Assert.assertEquals("Johnson", accounts.get(0).getLastName());
    } 
}
