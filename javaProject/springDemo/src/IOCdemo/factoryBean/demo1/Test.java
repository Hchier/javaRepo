package IOCdemo.factoryBean.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.TestConstructor;

public class Test {
    public void test(){
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("IOCdemo/factoryBean/demo1/bean.xml");
        Course mybean =applicationContext.getBean("mybean",Course.class);
        System.out.println(mybean);
    }
}

class Main{
    public static void main(String[] args) {
        Test test=new Test();
        test.test();
    }
}
