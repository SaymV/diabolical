package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.lmu.cs.diabolical.ws.dao.util.QueryBuilder;
import edu.lmu.cs.diabolical.ws.domain.Account;
import edu.lmu.cs.diabolical.ws.domain.Gender;

public class AccountDaoHibernateImpl extends HibernateDaoSupport implements AccountDao {

    @Override
    public Account findAccountById(Long id) {
        return getHibernateTemplate().get(Account.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Account> getAccountsByQuery(Gender gender, String username, String first, String last, int skip, int max) {
        QueryBuilder builder = new QueryBuilder("select a from Account a");

        if (gender != null) {
            builder.clause("a.gender = :sex", gender);
        }

        if (username != null) {
            builder.clause("lower(a.login) like lower(:username)", "%" +  username + "%");
        }
        
        if (first != null) {
            builder.clause("lower(a.firstName) like lower(:name)", "%" + first + "%");
        }
        
        if (last != null) {
            builder.clause("lower(a.lastName) like lower(:surname)", "%"+ last +"%");
        }

        return builder.build(getSession()).setFirstResult(skip).setMaxResults(max).list();
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
