import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void person(){
        ApplicationContext context=new ClassPathXmlApplicationContext("Person.xml");
        Person person = context.getBean("Person", Person.class);
        person.cat.action();
        person.dog.action();
    }
}
