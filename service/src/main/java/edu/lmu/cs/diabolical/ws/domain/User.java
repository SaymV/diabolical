package edu.lmu.cs.diabolical.ws.domain;

import java.util.List;

public class User {

    private Integer id;
    private String username;
    private Gender gender;
    private List<Account> accounts;
    
    public User() {
        // No arg constructor for annotations???
    }
    
    public User(Integer id, String username, Gender gender, List<Account> accounts) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.accounts = accounts;
    }
    
    public User(Integer id, String username, Gender gender) {
        this(id, username, gender, null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}
