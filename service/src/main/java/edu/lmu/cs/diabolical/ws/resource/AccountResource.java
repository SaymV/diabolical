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
    final String ACCOUNT_OVER_SPECIFIED = "account.over.specified";

    @GET
    @Path("{id}")
    public Account getAccountById(@PathParam("id") Long id);

    @GET
    public List<Account> getAccountsByQuery(@QueryParam("gender") Gender gender,
            @QueryParam("username") String username, @QueryParam("firstname") String first,
            @QueryParam("lastname") String lastname, @QueryParam("page") @DefaultValue("0") Integer page,
            @QueryParam("pageSize") @DefaultValue("10") Integer pageSize);

    @DELETE
    @Path("{id}")
    public Response deleteAccount(@PathParam("id") Long id);

    @POST
    public Response createAccount(Account account);

    @PUT
    @Path("{id}")
    public Response createOrUpdateAccount(@PathParam("id") Long id, Account account);
}
