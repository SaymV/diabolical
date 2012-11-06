package edu.lmu.cs.diabolical.ws.domain;

import java.util.List;

public class Character {

    private Integer id;
    private String name;
    private Integer gender;
    private String classType;
    private Integer level;
    private Long money;
    private List<Item> items;
    private List<Skill> skills;
    private List<Quest> accomplishedQuests;

    public void addAccomplishedQuest(Quest q) {
        this.accomplishedQuests.add(q);
    }

    public void addItem(Item i) {
        this.items.add(i);
    }

    public void addSkill(Skill s) {
        this.skills.add(s);
    }

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Quest> getAccomplishedQuests() {
        return accomplishedQuests;
    }

    public void setAccomplishedQuests(List<Quest> accomplishedQuests) {
        this.accomplishedQuests = accomplishedQuests;
    }
}
