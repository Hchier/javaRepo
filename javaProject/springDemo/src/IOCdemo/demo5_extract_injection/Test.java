package IOCdemo.demo5_extract_injection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public void test(){
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("IOCdemo/demo5_extract_injection/bean.xml");
        Student student =applicationContext.getBean("student", Student.class);
        System.out.println(student.getList());
        System.out.println(student.getCourses());
    }
}

class Main{
    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }
}