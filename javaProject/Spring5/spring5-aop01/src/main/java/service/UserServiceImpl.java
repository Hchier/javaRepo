package service;

import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("add方法");
    }

    public void delete() {
        System.out.println("delete方法");
    }
}
