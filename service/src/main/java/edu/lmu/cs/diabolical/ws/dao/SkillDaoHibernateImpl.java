package edu.lmu.cs.diabolical.ws.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.lmu.cs.diabolical.ws.domain.Skill;

public class SkillDaoHibernateImpl extends HibernateDaoSupport implements SkillDao{
	
	@Override
    public Skill getSkillById(Long id){
        return getHibernateTemplate().get(Skill.class, id);
    }
	
	@Override
    public Skill createSkill(Skill skill){
      	getHibernateTemplate().save(skill);
    	return skill;
    }
		   	 
	@Override
    public void createOrUpdateSkill(Skill skill){
        getHibernateTemplate().saveOrUpdate(skill);
    }
		   
	@Override
    public void deleteSkill(Skill skill){
        getHibernateTemplate().delete(skill);
    }
}
