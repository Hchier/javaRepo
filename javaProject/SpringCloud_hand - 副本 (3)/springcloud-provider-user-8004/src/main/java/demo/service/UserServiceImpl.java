package demo.service;

import demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pojo.User;

import java.util.List;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public void addUser(User user){
        userMapper.addUser(user);
    }
    @Override
    public User selectByName(String name){
        return userMapper.selectByName(name);
    }
    @Override
    public List<User> selectAll(){
        return userMapper.selectAll();
    }
}
