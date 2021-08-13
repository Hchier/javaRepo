package com.springboot.springbootdemo1;

import com.springboot.springbootdemo1.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springbootdemo1ApplicationTests {
    @Autowired
    User user;

    @Test
    void contextLoads() {
        System.out.println(user.toString());
    }

}
