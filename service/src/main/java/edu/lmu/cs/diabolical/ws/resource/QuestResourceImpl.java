package edu.lmu.cs.diabolical.ws.resource;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import edu.lmu.cs.diabolical.ws.domain.Quest;
import edu.lmu.cs.diabolical.ws.service.QuestService;

@Path("/quests")
public class QuestResourceImpl extends AbstractResource implements QuestResource{
	
	private QuestService questService;

    public QuestResourceImpl(QuestService questService){
        this.questService = questService;
    }

    @Override
    public Quest getQuestById(Long id){
        logServiceCall();

        Quest quest = questService.getQuestById(id);
        validate(quest != null, Response.Status.NOT_FOUND, QUEST_NOT_FOUND);

        return quest;
    }

    @Override
    public Response createQuest(Quest quest){
        logServiceCall();

        validate(quest.getId() == null, Response.Status.BAD_REQUEST, QUEST_OVERSPECIFIED);
        quest = questService.createQuest(quest);

        return Response.created(java.net.URI.create(Long.toString(quest.getId()))).build();
    }

    @Override
    public Response createOrUpdateQuest(Long id, Quest quest){
        logServiceCall();

        validate(id.equals(quest.getId()), Response.Status.BAD_REQUEST, ARGUMENT_CONFLICT);
        questService.createOrUpdateQuest(quest);

        return Response.noContent().build();
    }
    
    @Override
    public Response deleteQuestById(Long id){
    	logServiceCall();

        Quest quest = questService.getQuestById(id);
        validate(quest != null, Response.Status.NOT_FOUND, QUEST_NOT_FOUND);

        questService.deleteQuest(quest);
        return Response.noContent().build();
    }
}