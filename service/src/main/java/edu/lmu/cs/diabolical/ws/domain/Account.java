package edu.lmu.cs.diabolical.ws.domain;

import java.util.List;

public class Account {

    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

}
