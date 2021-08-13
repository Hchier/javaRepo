package annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component("AnnotationPointCut")
public class AnnotationPointCut {
    @After("execution(* service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("Annotation After");
    }
    @Before("execution(* service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("Annotation Before");
    }
    @Around("execution(* service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("annotation around before");
        pjp.proceed();
        System.out.println("annotation around after");
    }
}
