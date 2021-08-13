package IOCdemo.IOC_review;

import org.springframework.stereotype.Component;

@Component
public class Student {
    int age;
    String name;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
