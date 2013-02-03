package edu.lmu.cs.diabolical.ws.service;

import edu.lmu.cs.diabolical.ws.dao.SkillDao;
import edu.lmu.cs.diabolical.ws.domain.Skill;

public class SkillServiceImpl extends AbstractService implements SkillService {
	
	private SkillDao skillDao;
	
	public SkillServiceImpl(SkillDao skillDao){
	    this.skillDao = skillDao;
	}
	
	@Override
	public Skill getSkillById(Long id){
	    getLogger().debug("getSkillById");
	    return skillDao.getSkillById(id);
	}
	
	@Override
    public Skill createSkill(Skill skill){
    	getLogger().debug("createSkill");
	    return skillDao.createSkill(skill);
    }
	
	@Override
    public void createOrUpdateSkill(Skill skill){
    	getLogger().debug("createOrUpdateSkill");
    	skillDao.createOrUpdateSkill(skill);
	}
	
	@Override
    public void deleteSkill(Skill skill){
    	getLogger().debug("deleteSkill");
    	skillDao.deleteSkill(skill);
	}

}
