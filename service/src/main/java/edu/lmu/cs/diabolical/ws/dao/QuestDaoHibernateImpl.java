package edu.lmu.cs.diabolical.ws.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.lmu.cs.diabolical.ws.domain.Quest;


public class QuestDaoHibernateImpl extends HibernateDaoSupport implements QuestDao {

	@Override
    public Quest getQuestById(Long id){
        return getHibernateTemplate().get(Quest.class, id);
    }
	
	@Override
    public Quest createQuest(Quest quest){
        getHibernateTemplate().save(quest);
        return quest;    	
    }
    	   	 
	@Override
	public void createOrUpdateQuest(Quest quest){
	    getHibernateTemplate().saveOrUpdate(quest);
	}
	   
	@Override
	public void deleteQuest(Quest quest){
	    getHibernateTemplate().delete(quest);
	}
}
