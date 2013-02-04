package edu.lmu.cs.diabolical.ws.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import edu.lmu.cs.diabolical.ws.domain.Skill;

public class SkillTest{
    @Test
    public void testSkillConstructor(){
        Skill skill = new Skill(1L,"Skill 1", "First skill to be added");
        assertThat(skill.getId(), is(1L));
        assertThat(skill.getName(), is("Skill 1"));
        assertThat(skill.getDescription(), is("First skill to be added"));
    }

    @Test
    public void testSkillSetters(){
        Skill skill = new Skill();
        skill.setId(2L);
        skill.setName("Skill 1");
        skill.setDescription("Second skill to be added");
        assertThat(skill.getId(), is(2L));
        assertThat(skill.getName(), is("Skill 1"));
        assertThat(skill.getDescription(), is("Second skill to be added"));
    }
}
