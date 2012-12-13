package edu.lmu.cs.diabolical.ws.dao;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

import edu.lmu.cs.diabolical.ws.domain.Account;
import edu.lmu.cs.diabolical.ws.util.ApplicationContextTest;

public class AccountDaoTest extends ApplicationContextTest {

    private AccountDao accountDao;

    @Before
    public void getRequiredBeans() {
        accountDao = (AccountDao) applicationContext.getBean("accountDao");
    }

    @Test
    public void testFindAccountById() {
        Account a = accountDao.findAccountById(Long.valueOf(100001));
        Assert.assertEquals(a.getId(), Long.valueOf(100001));
        Assert.assertEquals(a.getFirstName(), "Jose");
        Assert.assertEquals(a.getLastName(), "Jose");
        Assert.assertEquals(a.getLogin(), "upswimsdn");
        Assert.assertEquals(a.getPassword(), "aaaaaa");
    }

    @Test
    public void testDeleteAccount() {
        Account preDelete = accountDao.findAccountById(Long.valueOf(100001));
        accountDao.deleteAccount(preDelete);
        Account postDelete = accountDao.findAccountById(Long.valueOf(100001));
        Assert.assertTrue(postDelete == null);
    }

    @Test
    public void testCreateAccount() {
        Account created = new Account(null, "first", "last", "test", "testagain", null);
        accountDao.createAccount(created);
        Account retrieved = accountDao.findAccountById(created.getId());
        Assert.assertEquals(created.getId(), retrieved.getId());
        Assert.assertEquals(created.getFirstName(), retrieved.getFirstName());
        Assert.assertEquals(created.getLastName(), retrieved.getLastName());
        Assert.assertEquals(created.getLogin(), retrieved.getLogin());
        Assert.assertEquals(created.getPassword(), retrieved.getPassword());
    }
    
    @Test
    public void testUpdateAccount() {
        Account accountToUpdate = accountDao.findAccountById(Long.valueOf(100001));
    }
}
