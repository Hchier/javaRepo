package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pojo.User;
import demo.service.*;

import java.util.Arrays;
import java.util.List;

@ConfigurationProperties(prefix="spring")
@RestController
class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/user/select/{username}")
    public User selectByUsername(@PathVariable String username) {
        return userServiceImpl.selectByUsername(username);
    }

    @RequestMapping("/user/test")
    public String test() {
        return "test";
    }

    @PostMapping("/user/selectall")
    public List<User> selectAll() {
        return userServiceImpl.selectAll();
    }

}

