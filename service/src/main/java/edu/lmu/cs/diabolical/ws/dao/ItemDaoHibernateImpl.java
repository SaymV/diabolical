package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.lmu.cs.diabolical.ws.dao.util.QueryBuilder;
import edu.lmu.cs.diabolical.ws.domain.Item;

public class ItemDaoHibernateImpl extends HibernateDaoSupport implements ItemDao {

    @Override
    public Item getItemById(Long id) {
        return getHibernateTemplate().get(Item.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Item> getItems(String slot, Integer minLevel, Integer maxLevel, int skip, int max) {
        return createItemQuery(slot, minLevel, maxLevel).build(getSession())
                .setFirstResult(skip)
                .setMaxResults(max)
                .list();
    }

    @Override
    public Item createItem(Item item) {
        getHibernateTemplate().save(item);
        return item;
    }

    @Override
    public void createOrUpdateItem(Item item) {
        getHibernateTemplate().saveOrUpdate(item);
    }

    /**
     * Returns a base HQL query object (no pagination) for the given parameters for items.
     */
    private QueryBuilder createItemQuery(String slot, Integer minLevel, Integer maxLevel) {
        // The desired return order is id.
        QueryBuilder builder = new QueryBuilder("select i from Item i", "order by id");

        if (slot != null) {
            builder.clause("lower(i.slot) like lower(:slot)", "%" + slot + "%");
        }

        if (minLevel != null) {
            builder.clause("i.level > :minlevel", minLevel);
        }

        if (maxLevel != null) {
            builder.clause("i.level < :maxlevel", maxLevel);
        }

        // All done.
        return builder;
    }
}
