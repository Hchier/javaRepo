import config.Config;
import config.Config2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojo.Cat;
import pojo.User;

public class MyTest {
    @Test
    public void user() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config2.class);
        User user = context.getBean("user", User.class);
        System.out.println(user.toString());
    }

    @Test
    public void cat() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config2.class);
        Cat cat = context.getBean("cat", Cat.class);
        System.out.println(cat.toString());
    }
}
