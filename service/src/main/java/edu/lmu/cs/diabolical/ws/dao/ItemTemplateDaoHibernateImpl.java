package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.lmu.cs.diabolical.ws.dao.util.QueryBuilder;
import edu.lmu.cs.diabolical.ws.domain.ItemTemplate;

public class ItemTemplateDaoHibernateImpl extends HibernateDaoSupport implements ItemTemplateDao {

    @Override
    public ItemTemplate getItemTemplateById(Long id) {
        return getHibernateTemplate().get(ItemTemplate.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ItemTemplate> getItemTemplates(String slot, Integer level, int skip, int max) {
        return createItemTemplateQuery(slot, level).build(getSession()).setFirstResult(skip).setMaxResults(max).list();
    }

    @Override
    public ItemTemplate createItemTemplate(ItemTemplate itemTemplate) {
        getHibernateTemplate().save(itemTemplate);
        return itemTemplate;
    }

    @Override
    public void createOrUpdateItemTemplate(ItemTemplate itemTemplate) {
        getHibernateTemplate().saveOrUpdate(itemTemplate);
    }

    /**
     * Returns a base HQL query object (no pagination) for the given parameters for item templates.
     */
    private QueryBuilder createItemTemplateQuery(String slot, Integer level) {
        // The desired return order is id.
        QueryBuilder builder = new QueryBuilder("select i from ItemTemplate i", "order by id");

        if (slot != null) {
            builder.clause("lower(i.slot) like lower(:slot)", "%" + slot + "%");
        }

        if (level != null) {
            builder.clause("i.minLevel < :level", level);
            builder.clause("i.maxLevel > :level", level);
        }

        return builder;
    }
}
