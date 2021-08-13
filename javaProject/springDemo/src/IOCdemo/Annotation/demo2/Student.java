package IOCdemo.Annotation.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Autowired
    @Qualifier(value = "name_is_study")
    Study study;
    @Value("jack")
    String name;

    public Study getStudy() {
        return study;
    }

    public String getName() {
        return name;
    }
}
