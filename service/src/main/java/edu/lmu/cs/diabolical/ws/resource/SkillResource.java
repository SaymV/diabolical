package edu.lmu.cs.diabolical.ws.resource;

import edu.lmu.cs.diabolical.ws.domain.Skill;

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

public interface SkillResource {
	
    String SKILL_NOT_FOUND = "skill.not.found";
    String SKILL_OVERSPECIFIED = "skill.overspecified";
        
    @GET
    @Path("/{id}")
    Skill getSkillById(@PathParam("id") Long id);

    @POST
    @Path("/")
    Response createSkill(Skill skill);
    
    @PUT
    @Path("{id}")
    Response createOrUpdateSkill(@PathParam("id") Long id, Skill skill);

    @DELETE
    @Path("/{id}")
    Response deleteSkillById(@PathParam("id") Long id);
}
