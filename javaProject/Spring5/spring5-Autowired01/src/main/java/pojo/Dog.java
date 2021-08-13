package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Dog {
    String name;
    public void action(){
        System.out.println("wang");
    }
}
