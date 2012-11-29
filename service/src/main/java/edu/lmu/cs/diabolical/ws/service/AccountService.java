package edu.lmu.cs.diabolical.ws.service;

import java.util.List;

import edu.lmu.cs.diabolical.ws.domain.Account;

public interface AccountService {
    public Account findAccountById(Long id);
    
    public List<Account> getAccounts(String query);
    
    public void deleteAccount(Account a);
    
    public void createAccount(Account a);
    
    public void createOrUpdateAccount(Account a);
}
