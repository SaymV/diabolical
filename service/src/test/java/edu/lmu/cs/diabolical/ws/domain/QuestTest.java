package edu.lmu.cs.diabolical.ws.domain;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;


public class QuestTest {
    @Test
    public void testQuestConstructor() {
        Quest quest = new Quest(1L, "One", "First quest added", "No clues, buddy!", "Best tester", new ArrayList<Character>());
        assertThat(quest.getId(), is(1L));
        assertThat(quest.getName(), is("One"));
        assertThat(quest.getDescription(), is("First quest added"));
        assertThat(quest.getClues(), is("No clues, buddy!"));
        assertThat(quest.getReward(), is("Best tester"));
    }

    @Test
    public void testQuestSetters() {
			  Quest quest = new Quest();
				quest.setId(2L);
				quest.setName("Two");
				quest.setDescription("Second quest added");
				quest.setClues("No clues yet!");
				quest.setReward("Ticket to nowhere");       
				assertThat(quest.getId(), is(2L));
        assertThat(quest.getName(), is("Two"));
        assertThat(quest.getDescription(), is("Second quest added"));
        assertThat(quest.getClues(), is("No clues yet!"));
        assertThat(quest.getReward(), is("Ticket to nowhere"));    
		}
}
