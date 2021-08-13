package JDBC_template.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Autowired
    JdbcTemplate template;
    public void test(){
        System.out.println("test");
    }

    public int add(){
        String sql="insert into student values(?,?)";
        int res = template.update(sql,"jack","10");
        return res;
    }
}
