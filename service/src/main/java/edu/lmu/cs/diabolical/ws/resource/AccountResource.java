package edu.lmu.cs.diabolical.ws.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.lmu.cs.diabolical.ws.domain.Account;
import edu.lmu.cs.diabolical.ws.domain.Gender;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AccountResource {

    final String ACCOUNT_NOT_FOUND = "account.not.found";

    @GET
    @Path("{id}")
    public Account getAccountById(@PathParam("id") Long id);

    @GET
    public List<Account> getAccountsByQuery(@QueryParam("gender") Gender gender,
            @QueryParam("username") String username, @QueryParam("name") String name, @QueryParam("page") @DefaultValue("0") String page,
            @QueryParam("pageSize") @DefaultValue("10") String pageSize);

    @DELETE
    @Path("{id}")
    public Response deleteAccount(Account account);

    @POST
    public Response createAccount(Account account);

    @PUT
    @Path("{id}")
    public Response updateAccount(Account account);
}
