import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

public class MyTest {
    @Test
    public void userTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("userBeans.xml");
        User user11 = context.getBean("User1", User.class);
        User user12 = context.getBean("User1", User.class);
        //单例模式 每次get得到的对象相同
        System.out.println(user11 == user12);

        User user21 = context.getBean("User2", User.class);
        User user22 = context.getBean("User2", User.class);
        //原型模式 每次get得到的对象  不  相同
        System.out.println(user21 == user22);
    }
}
