package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.lmu.cs.diabolical.ws.domain.Character;

public class CharacterDaoHibernateImpl extends HibernateDaoSupport implements CharacterDao {

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Character> getCharactersByQuery(String query) {
        return null;
    }

    public Character getCharacterById(Integer id) {
        return getHibernateTemplate().get(Character.class, id);
    }

    public void deleteCharacter(Character c) {
        getHibernateTemplate().delete(c);
    }

    public void createOrUpdateCharacter(Character c) {
        getHibernateTemplate().saveOrUpdate(c);
    }

    public Character createCharacter(Character c) {
        getHibernateTemplate().save(c);
        return c;
    }
}
