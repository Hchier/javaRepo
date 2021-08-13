package Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ServiceDemo {
    @Autowired
    Dao dao;
    public void transfer(String name1, String name2, int money) {
        dao.sub(name1, money);
        dao.add(name2, money);
    }
}

class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Test/bean.xml");
        ServiceDemo serviceDemo = applicationContext.getBean("serviceDemo", ServiceDemo.class);
        serviceDemo.transfer("Alice", "Bob", 100);
    }
}


