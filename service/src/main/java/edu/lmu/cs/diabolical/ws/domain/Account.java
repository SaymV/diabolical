package edu.lmu.cs.diabolical.ws.domain;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

//@Entity
@XmlRootElement
public class Account {

    private Integer id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private List<Character> characters;
    
    public Account() {
        
    }
    
    public Account(Integer id, String login, String password, List<Character> characters) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.characters = characters;
    }
    
    public Account(Integer id, String login, String password) {
        this(id, login, password, null);
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlAttribute
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @OneToMany
    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public void addCharacter(Character character) {
        this.characters.add(character);
    }
}
