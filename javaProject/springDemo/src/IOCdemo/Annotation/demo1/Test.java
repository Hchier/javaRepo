package IOCdemo.Annotation.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public void test() {
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("IOCdemo/Annotation/demo1/bean.xml");
        Student student = applicationContext.getBean("student", Student.class);

        System.out.println("age:" + student.getAge());
        System.out.println("name:" + student.getName());
        System.out.println("study:" +student.getStudy().study());
    }
}

class Main {
    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }
}
