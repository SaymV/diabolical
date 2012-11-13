package edu.lmu.cs.diabolical.ws.dao;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

import edu.lmu.cs.diabolical.ws.domain.Account;
import edu.lmu.cs.diabolical.ws.util.ApplicationContextTest;

public class AccountDaoTest extends ApplicationContextTest{

    private AccountDao accountDao;
    
    @Before
    public void setUp() {
        accountDao = (AccountDao) applicationContext.getBean("accountDao");
    }
    @Test
    public void testFindAccountById() {
        Account a = accountDao.findAccountById(1);
        Assert.assertEquals(a.getId(), Integer.valueOf(1));
        Assert.assertEquals(a.getFirstName(), "Jose");
        Assert.assertEquals(a.getLastName(), "Jose");
        Assert.assertEquals(a.getLogin(), "upswimsdn");
        Assert.assertEquals(a.getPassword(), "aaaaaa");
    }
}
