package IOCdemo.Annotation.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public void test(){
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("IOCdemo/Annotation/demo2");
        Student student=applicationContext.getBean("student",Student.class);
        student.getStudy().study();
        System.out.println(student.getName());
    }
}
//


class Main{
    public static void main(String[] args) {
        Test test=new Test();
        test.test();
    }
}
