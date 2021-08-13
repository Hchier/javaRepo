package demo2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

//在templates下的所有页面只能通过Controller访问，需要模板引擎的支持（导入thymeleaf的依赖）
@Controller
public class Test {
    @RequestMapping("/th")
    public String fk(Model model){
        model.addAttribute("result1","Hchier");
        model.addAttribute("result2","<h1>qwer</h1>");
        model.addAttribute("users", Arrays.asList("A","B","C"));
        return "th_test";
    }
}
