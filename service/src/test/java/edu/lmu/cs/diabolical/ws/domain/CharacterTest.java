package edu.lmu.cs.diabolical.ws.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

public class CharacterTest {
    @Test
    public void testCharacterConstructor() {
        Character c = new Character("Uncle Bob", Gender.MALE, "Coder", 99, 1000000000L, new ArrayList<Item>(),
                new ArrayList<Skill>(), new ArrayList<Quest>());
        assertThat(c.getId(), is(1));
        assertThat(c.getName(), is("Uncle Bob"));
        assertThat(c.getGender(), is(Gender.MALE));
        assertThat(c.getClassType(), is("Coder"));
        assertThat(c.getLevel(), is(99));
        assertThat(c.getMoney(), is(1000000000L));
        assertThat(c.getAccomplishedQuests().size(), is(0));
        assertThat(c.getItems().size(), is(0));
        assertThat(c.getSkills().size(), is(0));
    }

    @Test
    public void testCharacterSetters() {
        Character c = new Character("Uncle Bob", Gender.MALE, "Coder", 99, 1000000000L, new ArrayList<Item>(),
                new ArrayList<Skill>(), new ArrayList<Quest>());
        assertThat(c.getId(), is(1));
        c.setId(2);
        assertThat(c.getId(), is(2));

        assertThat(c.getName(), is("Uncle Bob"));
        c.setName("Homie D. Clown");
        assertThat(c.getName(), is("Homie D. Clown"));

        assertThat(c.getGender(), is(Gender.MALE));
        c.setGender(Gender.FEMALE);
        assertThat(c.getGender(), is(Gender.FEMALE));

        assertThat(c.getClassType(), is("Coder"));
        c.setClassType("Clown");
        assertThat(c.getClassType(), is("Clown"));

        assertThat(c.getLevel(), is(99));
        c.setLevel(37);
        assertThat(c.getLevel(), is(37));

        assertThat(c.getMoney(), is(1000000000L));
        c.setMoney(1217L);
        assertThat(c.getMoney(), is(1217L));

        assertThat(c.getAccomplishedQuests().size(), is(0));
        c.addAccomplishedQuest(new Quest());
        assertThat(c.getAccomplishedQuests().size(), is(1));

        assertThat(c.getItems().size(), is(0));
        c.addItem(new Item());
        assertThat(c.getItems().size(), is(1));

        assertThat(c.getSkills().size(), is(0));
        c.addSkill(new Skill());
        assertThat(c.getSkills().size(), is(1));
    }

    @Test
    public void testQuestItemSkillSetter() {
        Character c = new Character("Uncle Bob", Gender.MALE, "Coder", 99, 1000000000L, new ArrayList<Item>(),
                new ArrayList<Skill>(), new ArrayList<Quest>());

        assertThat(c.getAccomplishedQuests().size(), is(0));
        ArrayList<Quest> q = new ArrayList<Quest>();
        q.add(new Quest());
        q.add(new Quest());
        c.setAccomplishedQuests(q);
        assertThat(c.getAccomplishedQuests().size(), is(2));

        assertThat(c.getItems().size(), is(0));
        ArrayList<Item> i = new ArrayList<Item>();
        i.add(new Item());
        i.add(new Item());
        c.setItems(i);
        assertThat(c.getItems().size(), is(2));

        assertThat(c.getSkills().size(), is(0));
        ArrayList<Skill> s = new ArrayList<Skill>();
        s.add(new Skill());
        s.add(new Skill());
        c.setSkills(s);
        assertThat(c.getItems().size(), is(2));
    }
}
