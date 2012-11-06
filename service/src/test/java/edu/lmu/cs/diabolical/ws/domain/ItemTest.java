package edu.lmu.cs.diabolical.ws.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import edu.lmu.cs.diabolical.ws.domain.Item;

public class ItemTest {
    @Test
    public void fieldsSetByConstructorCanBeRead() {
        Item item = new Item(5L, "Bracer", 1600.0, 1450.0, 0.90, 2, 99.9, 99.8, 99.7, 30, 32);
        assertThat(item.getId(), is(5L));
        assertThat(item.getSlot(), is("Bracer"));
        assertThat(item.getMindamage(), is(1600.0));
        assertThat(item.getMaxdamage(), is(1450.0));
        assertThat(item.getCritchance(), is(0.9));
        assertThat(item.getAtkspeed(), is(2));
        assertThat(item.getDefense(), is(99.9));
        assertThat(item.getAbsorption(), is(99.8));
        assertThat(item.getBlockchance(), is(99.7));
        assertThat(item.getMinLevel(), is(30));
        assertThat(item.getMaxLevel(), is(32));
    }

    @Test
    public void fieldsSetBySettersCanBeRead() {
        Item item = new Item();
        item.setId(5L);
        item.setSlot("Bracer");
        item.setMindamage(1600.0);
        item.setMaxdamage(1450.0);
        item.setCritchance(0.90);
        item.setAtkspeed(2);
        item.setDefense(99.9);
        item.setAbsorption(99.8);
        item.setBlockchance(99.7);
        item.setMinLevel(32);
        item.setMaxLevel(90);
        assertThat(item.getId(), is(5L));
        assertThat(item.getSlot(), is("Bracer"));
        assertThat(item.getMindamage(), is(1600.0));
        assertThat(item.getMaxdamage(), is(1450.0));
        assertThat(item.getCritchance(), is(0.9));
        assertThat(item.getAtkspeed(), is(2));
        assertThat(item.getDefense(), is(99.9));
        assertThat(item.getAbsorption(), is(99.8));
        assertThat(item.getBlockchance(), is(99.7));
        assertThat(item.getMinLevel(), is(32));
        assertThat(item.getMaxLevel(), is(90));
    }

    @Test
    public void toStringProducesExpectedString() {
        Item item1 = new Item(5L, "Bracer", 1600.0, 1450.0, 0.90, 2, 99.9, 99.8, 99.7, 20, 23);
        String expected1 = "Item{id: 5, slot: Bracer, mindamage: 1600.0, maxdamage: 1450.0, critchance: 0.9, atkspeed: 2, defense: 99.9, absorption: 99.8, blockchance: 99.7, minlevel: 20, maxlevel: 23}";
        Item item2 = new Item();
        item2.setId(5L);
        item2.setSlot("Helm");
        item2.setMindamage(1600.0);
        item2.setMaxdamage(1599.0);
        item2.setCritchance(0.90);
        item2.setAtkspeed(2);
        item2.setDefense(99.9);
        item2.setAbsorption(99.8);
        item2.setBlockchance(100.0);
        item2.setMinLevel(40);
        item2.setMaxLevel(44);
        String expected2 = "Item{id: 5, slot: Helm, mindamage: 1600.0, maxdamage: 1599.0, critchance: 0.9, atkspeed: 2, defense: 99.9, absorption: 99.8, blockchance: 100.0, minlevel: 40, maxlevel: 44}";
        assertThat(item1.toString(), is(expected1));
        assertThat(item2.toString(), is(expected2));
    }

    @Test
    public void hashCodeProducesPrimePlusId() {
        // Where prime is set as 31
        assertThat(new Item(5L, "Bracer", 1600.0, 1450.0, 0.90, 2, 99.9, 99.8, 99.7, 21, 23).hashCode(), is(36));
    }

    @Test
    public void equalsUsesIdOnly() {
        assertThat(new Item(5L, "Bracer", 1600.0, 1450.0, 0.90, 2, 99.9, 99.8, 99.7, 21, 23), equalTo(new Item(5L, "Not",
                100.0, 140.0, 0.20, 1, 9.9, 9.8, 9.7, 32, 43)));
        assertThat(new Item(5L, "Bracer", 1600.0, 1450.0, 0.90, 2, 99.9, 99.8, 99.7, 32, 43), not(equalTo(new Item(7L,
                "Bracer", 1600.0, 1450.0, 0.90, 2, 99.9, 99.8, 99.7, 32, 43))));

        assertFalse(new Item(5L, "Bracer", 1600.0, 1450.0, 0.90, 2, 99.9, 99.8, 99.7, 12, 13).equals("some string"));
        assertFalse(new Item(5L, "Bracer", 1600.0, 1450.0, 0.90, 2, 99.9, 99.8, 99.7, 10, 20).equals(new Object()));
        assertFalse(new Item(5L, "Bracer", 1600.0, 1450.0, 0.90, 2, 99.9, 99.8, 99.7, 38, 43).equals(null));
    }

}
