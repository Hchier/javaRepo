import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        UserService userServiceImpl = context.getBean("UserServiceImpl", UserService.class);
        userServiceImpl.add();
    }
}
