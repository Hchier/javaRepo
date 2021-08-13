package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestfulController {
    //原来：http://localhost:8080/springmvc05_annotation_war/add?a=1&b=7
    //restful       ↓↓ ↓↓ ↓↓ ↓↓ ↓↓
    @RequestMapping(path="/add/{a}/{b}",method = RequestMethod.POST)
    public String test1(Model model, @PathVariable int a, @PathVariable int b) {
        int result = a + b;
        model.addAttribute("result", result);
        return "test";
    }
    @RequestMapping(path="/add/{a}/{b}",method = RequestMethod.GET)
    public String test2(Model model, @PathVariable int a, @PathVariable int b) {
        int result = a * b;
        model.addAttribute("result", result);
        return "test";
    }
}
