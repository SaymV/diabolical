package edu.lmu.cs.diabolical.ws.resource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import edu.lmu.cs.diabolical.ws.domain.Account;
import edu.lmu.cs.diabolical.ws.service.AccountService;

@Path("/accounts")
public class AccountResourceImpl extends AbstractResource implements AccountResource {

    private AccountService accountService;

    public AccountResourceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Account getAccountById(Long id) {
        logServiceCall();
        
        Account account = accountService.findAccountById(id);
        validate(account != null, Response.Status.NOT_FOUND, ACCOUNT_NOT_FOUND);
        
        return account;
    }

}
