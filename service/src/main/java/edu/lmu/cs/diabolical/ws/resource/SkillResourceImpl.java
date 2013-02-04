package edu.lmu.cs.diabolical.ws.resource;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import edu.lmu.cs.diabolical.ws.domain.Skill;
import edu.lmu.cs.diabolical.ws.service.SkillService;

@Path("/skills")
public class SkillResourceImpl extends AbstractResource implements SkillResource{
	
	private SkillService skillService;

    public SkillResourceImpl(SkillService skillService){
        this.skillService = skillService;
    }

    @Override
    public Skill getSkillById(Long id){
        logServiceCall();

        Skill skill = skillService.getSkillById(id);
        validate(skill != null, Response.Status.NOT_FOUND, SKILL_NOT_FOUND);

        return skill;
    }

    @Override
    public Response createSkill(Skill skill){
        logServiceCall();

        validate(skill.getId() == null, Response.Status.BAD_REQUEST, SKILL_OVERSPECIFIED);
        skill = skillService.createSkill(skill);

        return Response.created(java.net.URI.create(Long.toString(skill.getId()))).build();
    }

    @Override
    public Response createOrUpdateSkill(Long id, Skill skill){
        logServiceCall();

        validate(id.equals(skill.getId()), Response.Status.BAD_REQUEST, ARGUMENT_CONFLICT);
        skillService.createOrUpdateSkill(skill);

        return Response.noContent().build();
    }
    
    @Override
    public Response deleteSkillById(Long id){
    	logServiceCall();

        
        Skill skill = skillService.getSkillById(id);
        validate(skill != null, Response.Status.NOT_FOUND, SKILL_NOT_FOUND);

        skillService.deleteSkill(skill);
        return Response.noContent().build();
    }
}
