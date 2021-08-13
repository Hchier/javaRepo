package APOdemo.AspectJAnnotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

//增强类，编写增强逻辑
@Component
@Aspect  //生成代理对象
public class PersonProxy {
    //抽取公共切入点
    @Pointcut(value = "execution(* APOdemo.AspectJAnnotation.Person.walk(..))")
    public void walk_pointcut(){

    }

    //前置通知
    @Before(value = "walk_pointcut()")
    public void before(){
        System.out.println("before walk");
    }
    //方法执行之后执行
    @After(value = "walk_pointcut()")
    public void after(){
        System.out.println("after walk");
    }
    //方法返回结果之后执行
    @AfterReturning(value = "walk_pointcut()")
    public void afterreturning(){
        System.out.println("AfterReturning walk");
    }
    //异常通知，被增强的方法有异常时执行
    @AfterThrowing(value = "walk_pointcut()")
    public void afterthrowing(){
        System.out.println("afterthrowing walk");
    }

    @Around(value = "walk_pointcut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before around");
        //被增强的方法执行！！！！！！！！！！！！！！！！！！！！！！！
        proceedingJoinPoint.proceed();
        System.out.println("after around");
    }
}


class Test{
    public void test(){
        ApplicationContext applicationContext
//                = new ClassPathXmlApplicationContext("APOdemo/AspectJAnnotation/bean.xml");
        =new AnnotationConfigApplicationContext("APOdemo/AspectJAnnotation");
        Person person=applicationContext.getBean("person1",Person.class);
        person.walk();
    }
}

class Main{
    public static void main(String[] args) {
        Test test=new Test();
        test.test();
    }
}