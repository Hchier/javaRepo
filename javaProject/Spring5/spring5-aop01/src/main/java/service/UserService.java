package service;

import org.springframework.stereotype.Service;

@Service("UserService")
public interface UserService {
    void add();
    void delete();
}
