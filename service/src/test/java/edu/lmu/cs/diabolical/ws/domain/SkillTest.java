package edu.lmu.cs.diabolical.ws.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import edu.lmu.cs.diabolical.ws.domain.Skill;

public class SkillTest {
    @Test
    public void testSkillConstructor() {
        Skill skill = new skill(1L, "First skill to be added");
        assertThat(skill.getId(), is(1L));
        assertThat(skill.getDescription(), is("First skill to be added"));
    }

    @Test
    public void testSkillSetters() {
				Skill skill = new Skill();
        skill.setId(2L);
        skill.setDescription("Second skill to be added");
        assertThat(skill.getId(), is(2L));
        assertThat(skill.getName(), is("Second skill to be added"));
    }
}
