package IOCdemo.IOC_review;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext applicationContext=new AnnotationConfigApplicationContext("test1");
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("IOCdemo/IOC_review/bean.xml");
        Student student=applicationContext.getBean("student", Student.class);
        student.setAge(1);
        System.out.println(student.getAge());
    }
}
