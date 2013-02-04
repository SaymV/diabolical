package edu.lmu.cs.diabolical.ws.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class QuestTest{
    
	/*List<Character> sampleCharacterList;
    Character sampleCharacter = new Character("Hodor", Gender.MALE, null, null, null, null, null, null);
    Quest sampleQuest;

    @Before
    public void setUp() {
        sampleCharacterList = new ArrayList<Character>();
        sampleQuest = new Quest(null, null, null, null, null, sampleCharacterList);
    }*/
    
    @Test
    public void testQuestConstructor(){
        Quest quest = new Quest(1L, "One", "First quest added", "No clue, buddy!", "Best tester", new ArrayList<Character>());
        assertThat(quest.getId(), is(1L));
        assertThat(quest.getName(), is("One"));
        assertThat(quest.getDescription(), is("First quest added"));
        assertThat(quest.getClue(), is("No clue, buddy!"));
        assertThat(quest.getReward(), is("Best tester"));
        assertThat(quest.getCharacters().size(), is(0));
    }

    @Test
    public void testQuestSetters(){
	    Quest quest = new Quest();
		quest.setId(2L);
		quest.setName("Two");
		quest.setDescription("Second quest added");
		quest.setClue("No clue yet!");
		quest.setReward("Ticket to nowhere");  
		quest.setCharacters(new ArrayList<Character>());
		assertThat(quest.getId(), is(2L));
        assertThat(quest.getName(), is("Two"));
        assertThat(quest.getDescription(), is("Second quest added"));
        assertThat(quest.getClue(), is("No clue yet!"));
        assertThat(quest.getReward(), is("Ticket to nowhere"));
        assertThat(quest.getCharacters().size(), is(0));
    }
}
