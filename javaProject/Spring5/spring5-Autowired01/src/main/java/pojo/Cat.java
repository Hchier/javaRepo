package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cat {
    String name;
    public void action(){
        System.out.println("miao");
    }
}
