package demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CTest {
    @RequestMapping("/test")
    public String test(){
        return "thst;";
    }
}
