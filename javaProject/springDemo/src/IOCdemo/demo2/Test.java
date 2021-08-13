package IOCdemo.demo2;

import IOCdemo.demo2.getPerson.GetPerson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


class Test {
    public void get(){
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("IOCdemo/demo2/bean.xml");
        GetPerson getperson = applicationContext.getBean("getperson", IOCdemo.demo2.getPerson.GetPerson.class);
        getperson.getPerson1();
    }

}

class Main{
    public static void main(String[] args) {
        Test test =new Test();
        test.get();
    }
}

