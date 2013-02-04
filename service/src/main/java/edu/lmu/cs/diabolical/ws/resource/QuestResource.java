package edu.lmu.cs.diabolical.ws.resource;

import edu.lmu.cs.diabolical.ws.domain.Quest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public interface QuestResource{
	
	String QUEST_NOT_FOUND = "quest.not.found";
    String QUEST_OVERSPECIFIED = "quest.overspecified";
        
    @GET
    @Path("/{id}")
    Quest getQuestById(@PathParam("id") Long id);

    @POST
    @Path("/")
    Response createQuest(Quest quest);
    
    @PUT
    @Path("{id}")
    Response createOrUpdateQuest(@PathParam("id") Long id, Quest quest);

    @DELETE
    @Path("/{id}")
    Response deleteQuestById(@PathParam("id") Long id);
}
