package edu.lmu.cs.diabolical.ws.resource;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import edu.lmu.cs.diabolical.ws.domain.Account;
import edu.lmu.cs.diabolical.ws.domain.Gender;
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

    @Override
    public List<Account> getAccountsByQuery(Gender gender, String username, String name, String page, String pageSize) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response deleteAccount(Account account) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @POST
    public Response createAccount(Account account) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response updateAccount(Account account) {
        // TODO Auto-generated method stub
        return null;
    }

}
