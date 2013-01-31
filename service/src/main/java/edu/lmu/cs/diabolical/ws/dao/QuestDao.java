package edu.lmu.cs.diabolical.ws.dao;

import edu.lmu.cs.diabolical.ws.domain.Quest;

public interface QuestDao {
	
	/**
	 *  Returns the quest with the given id, or null if there's no quest with such id.
	 */	    
    Quest getQuestById(Long id);
	    
	/**
	 * Saves the given quest, which should have a null id.
	 */
	Quest createQuest(Quest quest);
	   	     
	/**
	 * Updates or saves the given quest, which should have a non-null id.
	 */
	void createOrUpdateQuest(Quest quest);
	   
	/**
	 * Deletes given quest.
	 */
	void deleteQuest(Quest quest);
	
}
