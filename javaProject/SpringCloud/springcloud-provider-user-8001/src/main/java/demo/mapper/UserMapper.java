package demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.User;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    public void addUser(User user);
    public User selectByName(String username);
    public List<User> selectAll();
}
