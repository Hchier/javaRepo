package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/w")
public class Hello1 {
    @RequestMapping("/w")
    public String hello(Model model){
        model.addAttribute("username","Hchier");
        return "fk";
    }
}
