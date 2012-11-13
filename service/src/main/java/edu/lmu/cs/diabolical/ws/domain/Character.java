package edu.lmu.cs.diabolical.ws.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@XmlRootElement
public class Character {

    private Integer id;
    private String name;
    private Gender gender;
    private String classType;
    private Integer level;
    private Long money;
    private List<Item> items;
    private List<Skill> skills;
    private List<Quest> accomplishedQuests;
    
    public Character() {
        // Empty arg constructor for annotations?
    }

    public Character(Integer id, String name, Gender gender, String classType, Integer level, Long money,
            List<Item> items, List<Skill> skills, List<Quest> accomplishedQuests) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.classType = classType;
        this.level = level;
        this.money = money;
        this.items =  items;
        this.skills = skills;
        this.accomplishedQuests = accomplishedQuests;
    }

    public void addAccomplishedQuest(Quest q) {
        this.accomplishedQuests.add(q);
    }

    public void addItem(Item i) {
        this.items.add(i);
    }

    public void addSkill(Skill s) {
        this.skills.add(s);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlAttribute
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Quest> getAccomplishedQuests() {
        return accomplishedQuests;
    }

    public void setAccomplishedQuests(List<Quest> accomplishedQuests) {
        this.accomplishedQuests = accomplishedQuests;
    }
}
