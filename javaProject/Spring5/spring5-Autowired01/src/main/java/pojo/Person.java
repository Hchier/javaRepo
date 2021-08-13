package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Getter
@Setter
@ToString
public class Person {
    //使用@Autowired可以不用setter
    @Autowired
    @Qualifier(value = "dog")
    public Dog dog;
    @Autowired
    public Cat cat;
    String name;
}
