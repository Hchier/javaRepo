package demo.service;

import org.springframework.stereotype.Service;
import pojo.User;

import java.util.List;

@Service
public interface UserService {
    public User selectByUsername(String username);
    public List<User> selectAll();
}