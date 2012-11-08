package edu.lmu.cs.diabolical.ws.dao;

import java.util.List;

import edu.lmu.cs.diabolical.ws.domain.User;

public interface UserDao {
    public List<User> getUsers();
    
    public User getUserById(Integer id);
    
    public void deleteUser(User u);
    
    public void createOrUpdateUser(User u);
    
    public void createUser(User u);
}
