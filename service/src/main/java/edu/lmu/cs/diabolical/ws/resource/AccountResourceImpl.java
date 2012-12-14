package edu.lmu.cs.diabolical.ws.resource;

import java.net.URI;
import java.util.List;

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
    public List<Account> getAccountsByQuery(Gender gender, String username, String first, String last, Integer page,
            Integer pageSize) {

        validate(gender != null || username != null || first != null || last != null, Response.Status.BAD_REQUEST,
                QUERY_REQUIRED);

        validatePagination(page, pageSize, 0, 50);
        
        
        return accountService.getAccountsByQuery(gender, username, first, last, page, pageSize);
    }

    @Override
    public Response deleteAccount(Long id) {
        logServiceCall();

        Account account = accountService.findAccountById(id);
        validate(account != null, Response.Status.NOT_FOUND, ACCOUNT_NOT_FOUND);

        accountService.deleteAccount(account);
        return Response.noContent().build();
    }

    @Override
    public Response createAccount(Account account) {
        logServiceCall();

        validate(account.getId() == null, Response.Status.BAD_REQUEST, ACCOUNT_OVER_SPECIFIED);

        accountService.createAccount(account);
        return Response.created(URI.create(Long.toString(account.getId()))).build();
    }

    @Override
    public Response createOrUpdateAccount(Long id, Account account) {
        logServiceCall();

        validate(id.equals(account.getId()), Response.Status.BAD_REQUEST, ARGUMENT_CONFLICT);

        accountService.createOrUpdateAccount(account);
        return null;
    }

}
