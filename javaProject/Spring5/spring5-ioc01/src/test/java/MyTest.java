import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void user() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        Object user = context.getBean("User");
        System.out.println(user.toString());
    }

    @Test
    public void userMgr() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(context.getBean("UserMgr").toString());
    }

    @Test
    public void person(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(context.getBean("person_alias").toString());
    }
}
