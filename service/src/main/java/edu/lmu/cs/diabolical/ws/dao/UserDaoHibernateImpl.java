package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.lmu.cs.diabolical.ws.domain.User;

public class UserDaoHibernateImpl extends HibernateDaoSupport implements UserDao {

    @Override
    public List<User> getUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        return getHibernateTemplate().get(User.class, id);
    }

    @Override
    public void deleteUser(User u) {
        getHibernateTemplate().delete(u);
    }

    @Override
    public void createOrUpdateUser(User u) {
        getHibernateTemplate().saveOrUpdate(u);
    }

    @Override
    public User createUser(User u) {
        getHibernateTemplate().save(u);
        return u;
    }

}
