package edu.lmu.cs.diabolical.ws.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.lmu.cs.diabolical.ws.domain.Account;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AccountResource {

    final String ACCOUNT_NOT_FOUND = "account.not.found";
    
    @GET
    @Path("{id}")
    public Account getAccountById(@PathParam("id") Long id);
}
