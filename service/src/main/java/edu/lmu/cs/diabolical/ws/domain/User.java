package edu.lmu.cs.diabolical.ws.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlAttribute
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

    @ManyToOne
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}
