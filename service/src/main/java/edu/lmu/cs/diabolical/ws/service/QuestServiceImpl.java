package edu.lmu.cs.diabolical.ws.service;

import edu.lmu.cs.diabolical.ws.dao.QuestDao;
import edu.lmu.cs.diabolical.ws.domain.Quest;

public class QuestServiceImpl extends AbstractService implements QuestService{
    
	private QuestDao questDao;
	
	public QuestServiceImpl(QuestDao questDao){
		this.questDao = questDao;
	}
	
	@Override
	public Quest getQuestById(Long id){
		getLogger().debug("getQuestById");
	    return questDao.getQuestById(id);
	}
	
	@Override
    public Quest createQuest(Quest quest){
    	getLogger().debug("createQuest");
        return questDao.createQuest(quest);
    }
           
	@Override
	public void createOrUpdateQuest(Quest quest){
		getLogger().debug("createOrUpdateQuest");
		questDao.createOrUpdateQuest(quest);
	}
	
	@Override
	public void deleteQuest(Quest quest){
		getLogger().debug("deleteQuest");
		questDao.deleteQuest(quest);
	}
}
