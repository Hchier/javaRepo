//package demo.service;
//
//import demo.dao.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import pojo.User;
//
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements demo.service.UserService{
//    @Autowired
//    private UserDao userDao;
//    @Override
//    public User selectByUsername(String username) {
//        return userDao.selectByUsername(username);
//    }
//    @Override
//    public List<User> selectAll() {
//        return userDao.selectAll();
//    }
//}
