import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cat {
    private String name;
    public void action(){
        System.out.println("miao~");
    }
}
