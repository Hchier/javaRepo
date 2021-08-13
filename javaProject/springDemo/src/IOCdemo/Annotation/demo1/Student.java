package IOCdemo.Annotation.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student{
    @Value(value = "bob")
    String name;
    @Value(value = "18")
    String age;
    @Autowired
    Study study;

    public Study getStudy() {
        return study;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
