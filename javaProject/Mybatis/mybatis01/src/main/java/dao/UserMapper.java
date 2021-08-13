package dao;

import pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();
    void addUser(User user);
    User selectByUsername(String username);
    User selectByUsernameAndPassword(String username,String password);
}
