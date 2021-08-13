package APOdemo.AspectJAnnotationDemo2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PersonProxy {
    @Pointcut(value = "execution(* APOdemo.AspectJAnnotationDemo2.Person.eat(..))")
    public void pointCut() {

    }

    @Before(value = "pointCut()")
    public void before() {
        System.out.println("wash wash hands");
    }

    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before");
        proceedingJoinPoint.proceed();
        System.out.println("around after");
    }

}

class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("APOdemo.AspectJAnnotationDemo2");
        Person person = applicationContext.getBean("person", Person.class);
        person.eat();
    }
}
