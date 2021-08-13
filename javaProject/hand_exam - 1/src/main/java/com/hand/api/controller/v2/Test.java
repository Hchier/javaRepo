package com.hand.api.controller.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class Test {
    @GetMapping("/test2")
    public String test(){
        return "test2";
    }
}
