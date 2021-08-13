package APOdemo.AspectJAnnotationDemo2;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Pointcut
    public void eat(){
        System.out.println("eat eat");
    }
}
