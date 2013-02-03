package edu.lmu.cs.diabolical.ws.service;

import edu.lmu.cs.diabolical.ws.domain.Quest;

public interface QuestService {
	    
    /**
	 *  Returns the quest with the given id, or null if there's no quest with such id.
	 */	    
    public Quest getQuestById(Long id);
	    
	/**
	 * Saves the given quest, which should have a null id.
	 */
	public Quest createQuest(Quest quest);
	   	     
	/**
	 * Updates or saves the given quest, which should have a non-null id.
	 */
	public void createOrUpdateQuest(Quest quest);
	   
	/**
	 * Deletes given quest.
	 */
	public void deleteQuest(Quest quest);
	
}
