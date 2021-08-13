package pojo;

import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "user")
@ToString
@Scope(value = "prototype")
public class User {
    private String name="hchier";
}
