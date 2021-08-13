package IOCdemo.autoWire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public void test() {
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("IOCdemo/autoWire/bean.xml");
        Employee employee = applicationContext.getBean("employee", Employee.class);
        System.out.println("department:" + employee.getDepartment());
    }
}

class Main{
    public static void main(String[] args) {
        Test test =new Test();
        test.test();
    }
}
