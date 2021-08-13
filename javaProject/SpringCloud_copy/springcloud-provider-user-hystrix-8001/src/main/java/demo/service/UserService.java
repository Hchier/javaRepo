package demo.service;

import pojo.User;

import java.util.List;

public interface UserService{
    public void addUser(User user);
    public User selectByName(String name);
    public List<User> selectAll();
}
