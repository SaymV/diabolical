package edu.lmu.cs.diabolical.ws.dao;

import edu.lmu.cs.diabolical.ws.domain.Skill;

public interface SkillDao {
	
	/**
	 *  Returns the skill with the given id, or null if there's no skill with such id.
	 */	    
    Skill getSkillById(Long id);
		    
    /**
     * Saves the given skill, which should have a null id.
     */
    Skill createSkill(Skill skill);
		   	     
    /**
     * Updates or saves the given skill, which should have a non-null id.
     */
    void createOrUpdateSkill(Skill skill);
		   
    /**
     * Deletes given skill.
     */
    void deleteSkill(Skill skill);
    
}
