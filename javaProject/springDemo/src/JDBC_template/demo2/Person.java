package JDBC_template.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "person1")
class Person {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int add(PersonInfo personInfo) {
        String sql = "insert into student values(?,?)";
        int res = jdbcTemplate.update(sql, personInfo.getName(), personInfo.getAge());
        return res;
    }

    public int[] batchAdd(List<Object[]> args) {
        String sql = "insert into student values(?,?)";
        int res[] = jdbcTemplate.batchUpdate(sql, args);
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setName("haha");
        personInfo.setAge("10");
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("JDBC_template/demo2/bean.xml");
        Person person = applicationContext.getBean("person1", Person.class);
//        System.out.println("add:" + person.add(personInfo));
        List<Object[]> batchArgs_add=new ArrayList<>();
        Object[] obj1={"ni",10};
        Object[] obj2={"hao",20};
        batchArgs_add.add(obj1);
        batchArgs_add.add(obj2);
        System.out.println(person.batchAdd(batchArgs_add));
    }
}