package edu.lmu.cs.diabolical.ws.service;

import java.util.List;

import edu.lmu.cs.diabolical.ws.domain.Account;
import edu.lmu.cs.diabolical.ws.domain.Gender;

public interface AccountService {
    public Account findAccountById(Long id);

    public List<Account> getAccountsByQuery(Gender gender, String login, String first, String last, int skip, int max);

    public void deleteAccount(Account a);

    public void createAccount(Account a);

    public void createOrUpdateAccount(Account a);
}
