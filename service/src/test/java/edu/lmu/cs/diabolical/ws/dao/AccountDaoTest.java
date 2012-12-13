package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import edu.lmu.cs.diabolical.ws.domain.Account;
import edu.lmu.cs.diabolical.ws.domain.Gender;
import edu.lmu.cs.diabolical.ws.util.ApplicationContextTest;

public class AccountDaoTest extends ApplicationContextTest {

    private AccountDao accountDao;

    @Before
    public void getRequiredBeans() {
        accountDao = (AccountDao) applicationContext.getBean("accountDao");
    }

    @Test
    public void findAccountById() {
        Account a = accountDao.findAccountById(Long.valueOf(100001));
        Assert.assertEquals(a.getId(), Long.valueOf(100001));
        Assert.assertEquals(a.getFirstName(), "Jose");
        Assert.assertEquals(a.getLastName(), "Jose");
        Assert.assertEquals(a.getLogin(), "upswimsdn");
        Assert.assertEquals(a.getPassword(), "aaaaaa");
    }

    @Test
    public void deleteAccount() {
        Account preDelete = accountDao.findAccountById(Long.valueOf(100001));
        accountDao.deleteAccount(preDelete);
        Account postDelete = accountDao.findAccountById(Long.valueOf(100001));
        Assert.assertTrue(postDelete == null);
    }

    @Test
    public void createAccount() {
        Account created = new Account(null, "first", "last", "test", "testagain", null, Gender.FEMALE);
        accountDao.createAccount(created);
        Account retrieved = accountDao.findAccountById(created.getId());
        Assert.assertEquals(created.getId(), retrieved.getId());
        Assert.assertEquals(created.getFirstName(), retrieved.getFirstName());
        Assert.assertEquals(created.getLastName(), retrieved.getLastName());
        Assert.assertEquals(created.getPassword(), retrieved.getPassword());
    }

    @Test
    public void updateAccount() {
        Account accountToUpdate = accountDao.findAccountById(Long.valueOf(100001));
        Assert.assertEquals(accountToUpdate.getLogin(), "upswimsdn");
        accountToUpdate.setLogin("butts");
        accountDao.createOrUpdateAccount(accountToUpdate);

        Account accountAfterUpdate = accountDao.findAccountById(Long.valueOf(100001));
        Assert.assertEquals(accountToUpdate.getLogin(), accountAfterUpdate.getLogin());
    }

    @Test
    public void getAccountsByGender() {
        List<Account> femalesOnly = accountDao.getAccountsByQuery(Gender.FEMALE, null, null, null, 0, 10);
        Assert.assertEquals(2, femalesOnly.size());
    }

    @Test
    public void getAccountsByUsername() {
        List<Account> accounts = accountDao.getAccountsByQuery(null, "ups", null, null, 0, 10);
        Assert.assertEquals(1, accounts.size());
        Assert.assertEquals("upswimsdn", accounts.get(0).getLogin());
        Assert.assertEquals(Long.valueOf(100001), accounts.get(0).getId());
        Assert.assertEquals("Jose", accounts.get(0).getFirstName());
        Assert.assertEquals("Jose", accounts.get(0).getLastName());
    }

    @Test
    public void getAcountsByUserNameAndGender() {
        List<Account> accounts = accountDao.getAccountsByQuery(Gender.FEMALE, "ups", null, null, 0, 10);
        Assert.assertEquals(0, accounts.size());

        accounts = accountDao.getAccountsByQuery(Gender.MALE, "ups", null, null, 0, 10);
        Assert.assertEquals(1, accounts.size());
        Assert.assertEquals("upswimsdn", accounts.get(0).getLogin());
        Assert.assertEquals(Long.valueOf(100001), accounts.get(0).getId());
        Assert.assertEquals("Jose", accounts.get(0).getFirstName());
        Assert.assertEquals("Jose", accounts.get(0).getLastName());
    }

    @Test
    public void getAccountsByFirstName() {
        List<Account> accounts = accountDao.getAccountsByQuery(null, null, "J", null, 0, 10);
        Assert.assertEquals(1, accounts.size());
        Assert.assertEquals("upswimsdn", accounts.get(0).getLogin());
        Assert.assertEquals(Long.valueOf(100001), accounts.get(0).getId());
        Assert.assertEquals("Jose", accounts.get(0).getFirstName());
        Assert.assertEquals("Jose", accounts.get(0).getLastName());
    }

    @Test
    public void getAccountsbyLastName() {
        List<Account> accounts = accountDao.getAccountsByQuery(null, null, null, "lI", 0, 10);
        Assert.assertEquals(1, accounts.size());
        Assert.assertEquals("lmulion", accounts.get(0).getLogin());
        Assert.assertEquals(Long.valueOf(100002), accounts.get(0).getId());
        Assert.assertEquals("Ignatius", accounts.get(0).getFirstName());
        Assert.assertEquals("Lion", accounts.get(0).getLastName());
    }

    @Test
    public void getAccountsByFirstAndLastName() {
        List<Account> accounts = accountDao.getAccountsByQuery(null, null, "i", "j", 0, 10);
        Assert.assertEquals(1, accounts.size());
        Assert.assertEquals("iz", accounts.get(0).getLogin());
        Assert.assertEquals(Long.valueOf(100004), accounts.get(0).getId());
        Assert.assertEquals("Isabelle", accounts.get(0).getFirstName());
        Assert.assertEquals("Johnson", accounts.get(0).getLastName());
    }

    @Test
    public void getAccountsByFullNameAndGender() {
        List<Account> accounts = accountDao.getAccountsByQuery(Gender.MALE, null, "i", "j", 0, 10);
        Assert.assertEquals(0, accounts.size());

        accounts = accountDao.getAccountsByQuery(Gender.FEMALE, null, "i", "j", 0, 10);
        Assert.assertEquals(1, accounts.size());
        Assert.assertEquals("iz", accounts.get(0).getLogin());
        Assert.assertEquals(Long.valueOf(100004), accounts.get(0).getId());
        Assert.assertEquals("Isabelle", accounts.get(0).getFirstName());
        Assert.assertEquals("Johnson", accounts.get(0).getLastName());
    }
    
    @Test
    public void getAccountsByFullNameGenderAndLogin() {
        List<Account> accounts = accountDao.getAccountsByQuery(Gender.FEMALE, "blue", "i", "j", 0, 10);
        Assert.assertEquals(0, accounts.size());
        
        accounts = accountDao.getAccountsByQuery(Gender.FEMALE, "i", "i", "j", 0, 10);
        Assert.assertEquals(1, accounts.size());
        Assert.assertEquals("iz", accounts.get(0).getLogin());
        Assert.assertEquals(Long.valueOf(100004), accounts.get(0).getId());
        Assert.assertEquals("Isabelle", accounts.get(0).getFirstName());
        Assert.assertEquals("Johnson", accounts.get(0).getLastName());
    }
}
