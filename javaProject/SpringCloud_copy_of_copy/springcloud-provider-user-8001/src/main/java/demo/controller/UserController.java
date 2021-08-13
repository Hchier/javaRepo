package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;
import demo.service.UserService;
import demo.service.UserServiceImpl;

import java.util.List;

//提供restful服务
@ConfigurationProperties(prefix="spring")
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/user/add")
    public void addUser(User user){
        userService.addUser(user);
    }
    @RequestMapping("/user/select/{name}")
    public User selectByName(@PathVariable String name){
        return userService.selectByName(name);
    }
    @RequestMapping("/user/selectall")
    public List<User> selectAll(){
        return userService.selectAll();
    }
}
