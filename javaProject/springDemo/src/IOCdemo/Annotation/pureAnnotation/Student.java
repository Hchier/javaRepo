package IOCdemo.Annotation.pureAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value(value = "Jack")
    String name;
    @Autowired
    Study study;

    public String getName() {
        return name;
    }

    public Study getStudy() {
        return study;
    }
}
