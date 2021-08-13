package demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;

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

    @RequestMapping("/user/selectall")
    public List<User> selectAll(){
        return userService.selectAll();
    }

    //失败了调用方法selectByNameHystrix
    @HystrixCommand(fallbackMethod = "selectByNameHystrix")
    @RequestMapping("/user/select/{name}")
    public User selectByName(@PathVariable String name){
        User user=userService.selectByName(name);
        if(user==null){
            throw new RuntimeException();//出现异常，调用方法selectByNameHystrix
        }
        return user;
    }
    public User selectByNameHystrix(@PathVariable String name){
        User user=new User();
        user.setUsername("查无此人@Hystrix");
        return user;
    }


}
