package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

import edu.lmu.cs.diabolical.ws.domain.Account;

public interface AccountDao {
    public Account findAccountById(Integer id);
    
    public List<Account> getAccountsByQuery(String query);
    
    public void deleteAccount(Account a);
    
    public void createOrUpdateAccount(Account a);
    
    public void createAccount(Account a);
}
