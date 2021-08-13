package APOdemo.review;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Aspect
class Proxy {
    @Before(value = "execution(* APOdemo.review.Person.run(..))")
    public void before() {
        System.out.println("before");
    }
    @Around(value = "execution(* APOdemo.review.Person.run(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before around");
        proceedingJoinPoint.proceed();
        System.out.println("after around");
    }
}

class Main{
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext("APOdemo.review");
        Person person= applicationContext.getBean("person",Person.class);
        person.run();
    }
}

