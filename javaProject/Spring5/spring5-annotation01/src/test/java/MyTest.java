import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = (User) context.getBean("user");
        User user2 = context.getBean("user", User.class);
        System.out.println(user1==user2);
    }
}
