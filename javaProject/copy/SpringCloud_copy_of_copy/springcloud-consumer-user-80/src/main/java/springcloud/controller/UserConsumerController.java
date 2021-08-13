package springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pojo.User;

import java.util.List;

@RestController //加Rest
public class UserConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    private static final String REST_URL_PREFIX = "http://localhost:8001/";

    @RequestMapping("consumer/user/select/{username}")
    public User selectByUsername(@PathVariable("username") String username) {
        return restTemplate.getForObject(REST_URL_PREFIX + "user/select/" + username, User.class);

    }

    @RequestMapping("consumer/user/selectall")
    public List<User> selectall() {
        return restTemplate.getForObject(REST_URL_PREFIX + "user/selectall", List.class);

    }
}
