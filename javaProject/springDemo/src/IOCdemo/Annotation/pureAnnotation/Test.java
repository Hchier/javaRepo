package IOCdemo.Annotation.pureAnnotation;

import IOCdemo.Annotation.pureAnnotation.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class Test {
    public void test() {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("IOCdemo/Annotation/pureAnnotation");
         Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student.getName());
        student.getStudy().study();
    }
}

class Main {
    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }
}

