package APOdemo.AspectJAnnotation;

import org.springframework.stereotype.Component;

@Component(value = "person1")
public class Person {
    public void walk(){
        System.out.println("person walks");
    }
}
