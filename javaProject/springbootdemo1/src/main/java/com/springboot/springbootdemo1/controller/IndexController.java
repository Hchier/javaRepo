package com.springboot.springbootdemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;


//跳到index.html.templates目录下的所有页面，只能通过controller来跳转
//需要模板引擎的支持
@Controller
public class IndexController {
    @RequestMapping("/thymeleafTest")
    public String index(Model model){
        model.addAttribute("username","Hchier");
        model.addAttribute("users", Arrays.asList("Hchier","PYH"));
        return "thymeleafTest";
    }
}
