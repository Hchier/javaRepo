package IOCdemo.demo3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public void test(){
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("IOCdemo/demo3/bean1.xml");
        Employee employee =applicationContext.getBean("employee",Employee.class);
        System.out.println("name:"+employee.getName());
        System.out.println("age:"+employee.getAge());
        System.out.println("department:"+employee.getDepartment().getName());
    }
}

class Main{
    public static void main(String[] args) {
        Test test=new Test();
        test.test();
    }
}