package edu.lmu.cs.diabolical.ws.service;

import java.util.List;

import edu.lmu.cs.diabolical.ws.dao.AccountDao;
import edu.lmu.cs.diabolical.ws.domain.Account;
import edu.lmu.cs.diabolical.ws.domain.Gender;
import exception.NoQueryProvidedException;

public class AccountServiceImpl extends AbstractService implements AccountService {

    private AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Long id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public List<Account> getAccountsByQuery(Gender gender, String login, String first, String last, int skip, int max) {
        verify(gender != null || login != null || first != null || last != null, new NoQueryProvidedException());
        return accountDao.getAccountsByQuery(gender, login, first, last, skip, max);
    }

    @Override
    public void deleteAccount(Account a) {
        accountDao.deleteAccount(a);
    }

    @Override
    public void createAccount(Account a) {
        accountDao.createAccount(a);
    }

    @Override
    public void createOrUpdateAccount(Account a) {
        accountDao.createOrUpdateAccount(a);
    }

}
