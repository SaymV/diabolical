package edu.lmu.cs.diabolical.ws.service;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import edu.lmu.cs.diabolical.ws.domain.Account;
import edu.lmu.cs.diabolical.ws.service.AccountService;
import edu.lmu.cs.diabolical.ws.util.ApplicationContextTest;

public class AccountServiceTest extends ApplicationContextTest {
    private AccountService accountService;

    @Before
    public void setUp() {
        accountService = (AccountService) applicationContext.getBean("accountService");
    }

    @Test
    public void testFindAccountById() {
        Account a = accountService.findAccountById(Long.valueOf(100001));
        Assert.assertEquals(a.getId(), Long.valueOf(100001));
        Assert.assertEquals(a.getFirstName(), "Jose");
        Assert.assertEquals(a.getLastName(), "Jose");
        Assert.assertEquals(a.getLogin(), "upswimsdn");
        Assert.assertEquals(a.getPassword(), "aaaaaa");
    }
}
