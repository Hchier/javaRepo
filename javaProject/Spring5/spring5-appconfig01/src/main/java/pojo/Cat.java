package pojo;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("cat")
@ToString
public class Cat {
    @Value("tom")
    String name;
}
