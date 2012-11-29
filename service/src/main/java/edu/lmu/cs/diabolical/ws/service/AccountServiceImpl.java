package edu.lmu.cs.diabolical.ws.service;

import java.util.List;

import edu.lmu.cs.diabolical.ws.dao.AccountDao;
import edu.lmu.cs.diabolical.ws.domain.Account;

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
    public List<Account> getAccounts(String query) {
        return accountDao.getAccountsByQuery(query);
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
