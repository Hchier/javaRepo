import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Getter
@Setter
@ToString
public class Person {
    @Autowired
    @Qualifier(value = "dog111")
    Dog dog;
    @Autowired
    Cat cat;
    String name;
}
