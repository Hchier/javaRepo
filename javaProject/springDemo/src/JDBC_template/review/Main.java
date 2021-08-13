package JDBC_template.review;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("JDBC_template/review/bean.xml");
        Student student=applicationContext.getBean("student", Student.class);
        System.out.println(student.add());



    }
}
