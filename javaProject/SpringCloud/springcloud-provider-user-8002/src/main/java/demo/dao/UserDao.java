package demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pojo.User;

import java.util.List;

@Mapper
@Repository
@Component
public interface UserDao {
    public User selectByUsername(String username);
    public List<User> selectAll();
}
