package JDBC_template.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "student1")
public class Student implements func {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public int add(StuInfo stuInfo) {
        String sql = "insert into student values(?,?)";
        int res = jdbcTemplate.update(sql, stuInfo.getName(), stuInfo.getAge());
        return res;
    }

    @Override
    public int update() {
        String sql = "update student set name=? where name='1'";
        int res = jdbcTemplate.update(sql, "jack");
        return res;
    }

    @Override
    public int delete() {
        String sql = "delete from student where name=?";
        int res = jdbcTemplate.update(sql, "jack");
        return res;
    }

    public int selectCount() {
        String sql = "select count(*) from student";
        //语句+需要返回的类型           查询表中有数据几条
        Integer res = jdbcTemplate.queryForObject(sql, Integer.class);
        return res;
    }

    //查询返回对象
    public StuInfo getStuInfo() {
        String sql = " select * from student where name=?";
        StuInfo stuInfo = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<StuInfo>(StuInfo.class), "Hchier");
        return stuInfo;
    }

    //查询返回对象集合
    public List<StuInfo> getStuInfos() {
        String sql = " select * from student";
        List<StuInfo> stuInfos = jdbcTemplate.query(sql, new BeanPropertyRowMapper<StuInfo>(StuInfo.class));
        return stuInfos;
    }

    //插入多组数据              用Object
    public int[] inserts(List<Object[]> batchArgs) {
        String sql = "insert into student values(?,?)";
        int a[] = jdbcTemplate.batchUpdate(sql, batchArgs);
        return a;
    }

    //删除多组数据
    public int[] deletes(List<Object[]> batchArgs) {
        String sql = "delete from student where name=?";
        int[] a = jdbcTemplate.batchUpdate(sql, batchArgs);
        return a;
    }


}
