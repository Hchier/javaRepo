package Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Dao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int add(String name, int money){
        String sql="update bank set money=money+? where username=?";
        int res= jdbcTemplate.update(sql,money,name);
        return res;
    }
    public int sub(String name, int money){
        String sql="update bank set money=money-? where username=?";
        int res= jdbcTemplate.update(sql,money,name);
        return res;
    }
}
