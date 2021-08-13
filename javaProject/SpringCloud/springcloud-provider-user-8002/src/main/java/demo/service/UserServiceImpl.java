package demo.service;

import demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pojo.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public User selectByUsername(String username) {
        return null;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }
}
