package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import edu.lmu.cs.diabolical.ws.domain.ItemTemplate;
import edu.lmu.cs.diabolical.ws.util.ApplicationContextTest;
import edu.lmu.cs.diabolical.ws.util.DomainObjectUtils;

public class ItemTemplateDaoTest extends ApplicationContextTest {

    private ItemTemplateDao itemTemplateDao;

    @Before
    public void getRequiredBeans() {
        itemTemplateDao = (ItemTemplateDao) applicationContext.getBean("itemTemplateDao");
    }

    @Test
    public void testGetItemTemplateById() {
        ItemTemplate itemTemplate = itemTemplateDao.getItemTemplateById(5000000L);

        Assert.assertEquals(Long.valueOf(5000000L), itemTemplate.getId());
        Assert.assertEquals("MyBracer", itemTemplate.getName());
        Assert.assertEquals("Bracer", itemTemplate.getSlot());
        Assert.assertEquals(1400.0, itemTemplate.getMinMindamage());
        Assert.assertEquals(1450.0, itemTemplate.getMaxMindamage());
        Assert.assertEquals(1700.0, itemTemplate.getMinMaxdamage());
        Assert.assertEquals(1750.0, itemTemplate.getMaxMaxdamage());
        Assert.assertEquals(0.9, itemTemplate.getMinCritchance());
        Assert.assertEquals(0.99, itemTemplate.getMaxCritchance());
        Assert.assertEquals(2, itemTemplate.getMinAtkspeed().intValue());
        Assert.assertEquals(5, itemTemplate.getMaxAtkspeed().intValue());
        Assert.assertEquals(20, itemTemplate.getMinLevel().intValue());
        Assert.assertEquals(30, itemTemplate.getMaxLevel().intValue());
    }

    @Test
    public void testGetItemTemplatesBySlot() {
        List<ItemTemplate> itemTemplates = itemTemplateDao.getItemTemplates(null, "Brace");

        Assert.assertEquals(1, itemTemplates.size());
        Assert.assertEquals(Long.valueOf(5000000L), itemTemplates.get(0).getId());
    }

    @Test
    public void testGetItemTemplatesByLevel() {
        List<ItemTemplate> itemTemplates = itemTemplateDao.getItemTemplates(40, null);
        Assert.assertEquals(1, itemTemplates.size());
        Assert.assertEquals(Long.valueOf(5000001L), itemTemplates.get(0).getId());
    }

    @Test
    public void testGetItemTemplatesByInvalidQuery() {
        List<ItemTemplate> itemTemplates = itemTemplateDao.getItemTemplates(null, "blarg");
        Assert.assertEquals(0, itemTemplates.size());
    }

    @Test
    public void testCreateItemTemplate() {
        ItemTemplate itemTemplateToCreate = DomainObjectUtils.createItemTemplateObject("Super Soaker", "mainhand", 2.0,
                4.0, 8.0, 8.9, 0.5, 0.58, 1, 2, 5, 8, null, null, null, null, null, null);

        itemTemplateDao.createItemTemplate(itemTemplateToCreate);

        Assert.assertEquals(Long.valueOf(1L), itemTemplateToCreate.getId());

        ItemTemplate createdItemTemplate = itemTemplateDao.getItemTemplateById(1L);
        assertSimpleEquality(itemTemplateToCreate, createdItemTemplate);
    }

    @Test
    public void testCreateAndUpdateItemTemplate() {
        ItemTemplate itemTemplateToCreate = DomainObjectUtils.createItemTemplateObject("Super Soaker", "mainhand", 2.0,
                4.0, 8.0, 8.9, 0.5, 0.58, 1, 2, 5, 8, null, null, null, null, null, null);
        ItemTemplate itemTemplateToReplaceWith = DomainObjectUtils.createItemTemplateObject("Tennis Band", "wrist",
                null, null, null, null, null, null, null, null, 5, 8, 35.0, 38.5, 0.05, 0.1, 0.02, 0.04);

        itemTemplateDao.createItemTemplate(itemTemplateToCreate);

        Long createdItemTemplateId = itemTemplateToCreate.getId();
        itemTemplateToReplaceWith.setId(createdItemTemplateId);

        itemTemplateDao.createOrUpdateItemTemplate(itemTemplateToReplaceWith);
        ItemTemplate createdItemTemplate = itemTemplateDao.getItemTemplateById(createdItemTemplateId);

        assertSimpleEquality(itemTemplateToReplaceWith, createdItemTemplate);
        Assert.assertNotSame(createdItemTemplate.getName(), itemTemplateToCreate.getName());
        Assert.assertNotSame(createdItemTemplate.getSlot(), itemTemplateToCreate.getSlot());
        Assert.assertNotSame(createdItemTemplate.getMinMindamage(), itemTemplateToCreate.getMinMindamage());
        Assert.assertNotSame(createdItemTemplate.getMaxMindamage(), itemTemplateToCreate.getMaxMindamage());
        Assert.assertNotSame(createdItemTemplate.getMinDefense(), itemTemplateToCreate.getMinDefense());
        Assert.assertNotSame(createdItemTemplate.getMaxAbsorption(), itemTemplateToCreate.getMaxAbsorption());
    }

    /**
     * Helper function for asserting the equality of two itemTemplates.
     */
    private void assertSimpleEquality(ItemTemplate itemTemplate1, ItemTemplate itemTemplate2) {
        Assert.assertEquals(itemTemplate1.getId(), itemTemplate2.getId());
        Assert.assertEquals(itemTemplate1.getName(), itemTemplate2.getName());
        Assert.assertEquals(itemTemplate1.getSlot(), itemTemplate2.getSlot());
        Assert.assertEquals(itemTemplate1.getMinMindamage(), itemTemplate2.getMinMindamage());
        Assert.assertEquals(itemTemplate1.getMaxMindamage(), itemTemplate2.getMaxMindamage());
        Assert.assertEquals(itemTemplate1.getMinMaxdamage(), itemTemplate2.getMinMaxdamage());
        Assert.assertEquals(itemTemplate1.getMaxMaxdamage(), itemTemplate2.getMaxMaxdamage());
        Assert.assertEquals(itemTemplate1.getMinDefense(), itemTemplate2.getMinDefense());
        Assert.assertEquals(itemTemplate1.getMinLevel(), itemTemplate2.getMinLevel());
        Assert.assertEquals(itemTemplate1.getMaxLevel(), itemTemplate2.getMaxLevel());
    }
}
