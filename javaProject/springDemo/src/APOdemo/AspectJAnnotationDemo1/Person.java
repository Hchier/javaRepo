package APOdemo.AspectJAnnotationDemo1;


import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component(value = "person2")
public class Person {
    @Pointcut
    public void eat(){
        System.out.println("eat eat");
    }
}
