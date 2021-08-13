package APOdemo.AspectJAnnotationDemo1;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PersonProxy {
    @After(value = "execution(* APOdemo.AspectJAnnotationDemo1.Person.eat(..))")
    public void after(){
        System.out.println("after eat");
    }
}

class Main{
    public static void main(String[] args) {
        ApplicationContext applicationContext
//                = new ClassPathXmlApplicationContext("APOdemo/AspectJAnnotationDemo1/bean.xml");
        =new AnnotationConfigApplicationContext("APOdemo.AspectJAnnotationDemo1");
        Person person =applicationContext.getBean("person2",Person.class);
        person.eat();
    }
}


