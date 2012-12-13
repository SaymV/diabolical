package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

import edu.lmu.cs.diabolical.ws.domain.Account;
import edu.lmu.cs.diabolical.ws.domain.Gender;

public interface AccountDao {
    public Account findAccountById(Long id);

    public List<Account> getAccountsByQuery(Gender gender, String username, String first, String last, int skip, int max);

    public void deleteAccount(Account a);

    public void createOrUpdateAccount(Account a);

    public void createAccount(Account a);
}
