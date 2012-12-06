package edu.lmu.cs.diabolical.ws.domain;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * An item template is used to random generate Item objects.
 */
//@Entity
@XmlRootElement
public class ItemTemplate {

    private Long id;
    private String name;
    private String slot;
    private Double minMindamage;
    private Double maxMindamage;
    private Double minMaxdamage;
    private Double maxMaxdamage;
    private Double minCritchance;
    private Double maxCritchance;
    private Integer minAtkspeed;
    private Integer maxAtkspeed;
    private Integer minLevel;
    private Integer maxLevel;
    private Double minDefense;
    private Double maxDefense;
    private Double minAbsorption;
    private Double maxAbsorption;
    private Double minBlockchance;
    private Double maxBlockchance;

    public ItemTemplate() {
        // No-arg constructor
    }

    public ItemTemplate(Long id, String name, String slot, Double minMindamage, Double maxMindamage,
            Double minMaxdamage, Double maxMaxdamage, Double minCritchance, Double maxCritchance, Integer minAtkspeed,
            Integer maxAtkspeed, Integer minLevel, Integer maxLevel, Double minDefense, Double maxDefense,
            Double minAbsorption, Double maxAbsorption, Double minBlockchance, Double maxBlockchance) {
        this.id = id;
        this.name = name;
        this.slot = slot;
        this.minMindamage = minMindamage;
        this.maxMindamage = maxMindamage;
        this.minMaxdamage = minMaxdamage;
        this.maxMaxdamage = maxMaxdamage;
        this.minCritchance = minCritchance;
        this.maxCritchance = maxCritchance;
        this.minAtkspeed = minAtkspeed;
        this.maxAtkspeed = maxAtkspeed;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.minDefense = minDefense;
        this.maxDefense = maxDefense;
        this.minAbsorption = minAbsorption;
        this.maxAbsorption = maxAbsorption;
        this.minBlockchance = minBlockchance;
        this.maxBlockchance = maxBlockchance;
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlAttribute
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    @Lob
    public String getName() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

//    @Lob
    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public Double getMinMindamage() {
        return minMindamage;
    }

    public void setMinMindamage(Double minMindamage) {
        this.minMindamage = minMindamage;
    }

    public Double getMaxMindamage() {
        return maxMindamage;
    }

    public void setMaxMindamage(Double maxMindamage) {
        this.maxMindamage = maxMindamage;
    }

    public Double getMinMaxdamage() {
        return minMaxdamage;
    }

    public void setMinMaxdamage(Double minMaxdamage) {
        this.minMaxdamage = minMaxdamage;
    }

    public Double getMaxMaxdamage() {
        return maxMaxdamage;
    }

    public void setMaxMaxdamage(Double maxMaxdamage) {
        this.maxMaxdamage = maxMaxdamage;
    }

    public Double getMinCritchance() {
        return minCritchance;
    }

    public void setMinCritchance(Double minCritchance) {
        this.minCritchance = minCritchance;
    }

    public Double getMaxCritchance() {
        return maxCritchance;
    }

    public void setMaxCritchance(Double maxCritchance) {
        this.maxCritchance = maxCritchance;
    }

    public Integer getMinAtkspeed() {
        return minAtkspeed;
    }

    public void setMinAtkspeed(Integer minAtkspeed) {
        this.minAtkspeed = minAtkspeed;
    }

    public Integer getMaxAtkspeed() {
        return maxAtkspeed;
    }

    public void setMaxAtkspeed(Integer maxAtkspeed) {
        this.maxAtkspeed = maxAtkspeed;
    }

    public Double getMinDefense() {
        return minDefense;
    }

    public void setMinDefense(Double minDefense) {
        this.minDefense = minDefense;
    }

    public Double getMaxDefense() {
        return maxDefense;
    }

    public void setMaxDefense(Double maxDefense) {
        this.maxDefense = maxDefense;
    }

    public Double getMinAbsorption() {
        return minAbsorption;
    }

    public void setMinAbsorption(Double minAbsorption) {
        this.minAbsorption = minAbsorption;
    }

    public Double getMaxAbsorption() {
        return maxAbsorption;
    }

    public void setMaxAbsorption(Double maxAbsorption) {
        this.maxAbsorption = maxAbsorption;
    }

    public Double getMinBlockchance() {
        return minBlockchance;
    }

    public void setMinBlockchance(Double minBlockchance) {
        this.minBlockchance = minBlockchance;
    }

    public Double getMaxBlockchance() {
        return maxBlockchance;
    }

    public void setMaxBlockchance(Double maxBlockchance) {
        this.maxBlockchance = maxBlockchance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(Integer minLevel) {
        this.minLevel = minLevel;
    }

    public Integer getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }

    public void setDamageRange(Double minMindamage, Double maxMindamage, Double minMaxdamage, Double maxMaxdamage) {
        this.minMindamage = minMindamage;
        this.maxMindamage = maxMindamage;
        this.minMaxdamage = minMaxdamage;
        this.maxMaxdamage = maxMaxdamage;
    }

    public void setLevelRange(Integer minLevel, Integer maxLevel) {
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
    }

    public void setCritchanceRange(Double minCritchance, Double maxCritchance) {
        this.minCritchance = minCritchance;
        this.maxCritchance = maxCritchance;
    }

    public void setAtkspeedRange(Integer minAtkspeed, Integer maxAtkspeed) {
        this.minAtkspeed = minAtkspeed;
        this.maxAtkspeed = maxAtkspeed;
    }

    public void setDefenseRange(Double minDefense, Double maxDefense) {
        this.minDefense = minDefense;
        this.maxDefense = maxDefense;
    }

    public void setBlockchanceRange(Double minBlockchance, Double maxBlockchance) {
        this.minBlockchance = minBlockchance;
        this.maxBlockchance = maxBlockchance;
    }

    public void setAbsorptionRange(Double minAbsorption, Double maxAbsorption) {
        this.minAbsorption = minAbsorption;
        this.maxAbsorption = maxAbsorption;
    }

    @Override
    public String toString() {
        return "Item{id: " + id + ", slot: " + slot + ", minMindamage: " + minMindamage + ", maxMindamage: "
                + maxMindamage + ", minMaxdamage: " + minMaxdamage + ", maxMaxdamage: " + maxMaxdamage
                + ", minCritchance: " + minCritchance + ", maxCritchance: " + maxCritchance + ", minAtkspeed: "
                + minAtkspeed + ", : maxAtkspeed" + maxAtkspeed + ", minDefense: " + minDefense + ", maxDefense: "
                + maxDefense + ", minlevel: " + minLevel + ", maxlevel: " + maxLevel + ", minBlockchance: "
                + minBlockchance + ", maxBlockchance: " + maxBlockchance + ", minAbsorption: " + minAbsorption
                + ", maxAbsorption: " + maxAbsorption + "}";
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
        ItemTemplate other = (ItemTemplate) obj;
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
