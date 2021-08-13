package IOCdemo.demo4_collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Test {
    public void test(){
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("IOCdemo/demo4_collection/bean.xml");
        Student student =applicationContext.getBean("student", Student.class);
        System.out.println(student.getCourses().toString());
        System.out.println(student.getMap());
        System.out.println(student.getMap());
        System.out.println(student.getSet());
    }
}

class Main{
    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }
}