package edu.lmu.cs.diabolical.ws.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * An item is equippable by a character and provides changes to charstats.
 */
@Entity
@XmlRootElement
public class Item {

    private Long id;
    private String name;
    private String slot;
    private Double mindamage;
    private Double maxdamage;
    private Double critchance;
    private Integer atkspeed;
    private Integer level;
    private Double defense;
    private Double absorption;
    private Double blockchance;

    public Item() {
        // No-arg constructor
    }

    public Item(Long id, String name, String slot, Double mindamage, Double maxdamage, Double critchance,
            Integer atkspeed, Double defense, Double absorption, Double blockchance, Integer level) {
        this.id = id;
        this.name = name;
        this.slot = slot;
        this.mindamage = mindamage;
        this.maxdamage = maxdamage;
        this.critchance = critchance;
        this.atkspeed = atkspeed;
        this.defense = defense;
        this.absorption = absorption;
        this.blockchance = blockchance;
        this.level = level;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlAttribute
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Lob
    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public Double getMindamage() {
        return mindamage;
    }

    public void setMindamage(Double mindamage) {
        this.mindamage = mindamage;
    }

    public Double getMaxdamage() {
        return maxdamage;
    }

    public void setMaxdamage(Double maxdamage) {
        this.maxdamage = maxdamage;
    }

    public Double getCritchance() {
        return critchance;
    }

    public void setCritchance(Double critchance) {
        this.critchance = critchance;
    }

    public Integer getAtkspeed() {
        return atkspeed;
    }

    public void setAtkspeed(Integer atkspeed) {
        this.atkspeed = atkspeed;
    }

    public Double getDefense() {
        return defense;
    }

    public void setDefense(Double defense) {
        this.defense = defense;
    }

    public Double getAbsorption() {
        return absorption;
    }

    public void setAbsorption(Double absorption) {
        this.absorption = absorption;
    }

    public Double getBlockchance() {
        return blockchance;
    }

    public void setBlockchance(Double blockchance) {
        this.blockchance = blockchance;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Lob
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{id: " + id + ", name: " + name + ", slot: " + slot + ", mindamage: " + mindamage + ", maxdamage: "
                + maxdamage + ", critchance: " + critchance + ", atkspeed: " + atkspeed + ", defense: " + defense
                + ", absorption: " + absorption + ", blockchance: " + blockchance + ", level: " + level + "}";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Item other = (Item) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
}
