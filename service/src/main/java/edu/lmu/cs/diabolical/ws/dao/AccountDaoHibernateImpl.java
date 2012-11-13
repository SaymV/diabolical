package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.lmu.cs.diabolical.ws.domain.Account;

public class AccountDaoHibernateImpl extends HibernateDaoSupport implements AccountDao{

    @Override
    public Account findUserById(Integer id) {
        return getHibernateTemplate().get(Account.class, id);
    }

    @Override
    public List<Account> getAccountsByQuery(String query) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteAccount(Account a) {
        getHibernateTemplate().delete(a);
        
    }

    @Override
    public void createOrUpdateAccount(Account a) {
        getHibernateTemplate().saveOrUpdate(a);
        
    }

    @Override
    public void createAccount(Account a) {
        getHibernateTemplate().save(a);
        
    }

}
