package com.example.springbootdemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @RequestMapping("/login")
    //@ResponseBody
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password){
        System.out.println("username,password"+username+password);
        if(username.equals("1") && password.equals("1"))
            return "index";
        else
            return "loginfail";
    }
}
