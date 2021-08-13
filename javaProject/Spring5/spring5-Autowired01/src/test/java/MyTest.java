import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Person;

public class MyTest {
    @Test
    public void personTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("personBeans.xml");
        Person person = context.getBean("person", Person.class);
        person.cat.action();
        person.dog.action();
    }
    @Test
    public void personAnnotationTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("personAnnotaBeans.xml");
        Person person = context.getBean("person", Person.class);
        person.cat.action();
        person.dog.action();
    }
}
