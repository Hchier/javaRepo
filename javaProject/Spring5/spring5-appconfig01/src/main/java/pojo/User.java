package pojo;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "user")
@ToString
@Scope(value = "prototype")
public class User {
    @Value("Hchier")
    private String name;
    @Autowired
    Cat cat;
}
