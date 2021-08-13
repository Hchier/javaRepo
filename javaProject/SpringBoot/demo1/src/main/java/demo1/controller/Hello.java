package demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //返回字符串
public class Hello {
    @RequestMapping("/fk")
    public String hello(){
        return "fk u haah";
    }
}
