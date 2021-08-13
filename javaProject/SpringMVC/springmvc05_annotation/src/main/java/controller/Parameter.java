package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.User;

@Controller
@RequestMapping("/p")
public class Parameter {
    @RequestMapping("/a")
    public void accept(User user){
        System.out.println(user);
    }

}
