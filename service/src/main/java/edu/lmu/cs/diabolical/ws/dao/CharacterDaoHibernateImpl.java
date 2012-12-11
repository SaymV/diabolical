package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.lmu.cs.diabolical.ws.dao.util.QueryBuilder;
import edu.lmu.cs.diabolical.ws.domain.Character;
import edu.lmu.cs.diabolical.ws.domain.Gender;

public class CharacterDaoHibernateImpl extends HibernateDaoSupport implements CharacterDao {

    // Tested
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @SuppressWarnings("unchecked")
    public List<Character> getCharacters(String name, String className, Gender gender, Integer minLevel, Integer maxLevel) {
        return createCharacterQuery(name, className, gender, minLevel, maxLevel).build(getSession()).list();
    }

    // Tested
    public Character getCharacterById(Integer id) {
        return getHibernateTemplate().get(Character.class, id);
    }

    // Tested
    public void deleteCharacter(Character c) {
        getHibernateTemplate().delete(c);
    }

    // Tested
    public Character createOrUpdateCharacter(Character c) {
        getHibernateTemplate().saveOrUpdate(c);
        return c;
    }

    // Tested
    public Character createCharacter(Character c) {
        getHibernateTemplate().save(c);
        return c;
    }

    private QueryBuilder createCharacterQuery(String name, String className, Gender gender, Integer minLevel, Integer maxLevel) {
        QueryBuilder builder = new QueryBuilder("select c from Character c", "order by id");

        if (name != null) {
            builder.clause("c.name = :name", name);
        }

        if (className != null) {
            builder.clause("c.classType = :className", className);
        }

        if (gender != null) {
            builder.clause("c.gender = :gender", gender);
        }

        if (minLevel != null) {
            builder.clause("c.level >= :minLevel", minLevel);
        }

        if (maxLevel != null) {
            builder.clause("c.level <= :maxLevel", maxLevel);
        }

        return builder;
    }
}
