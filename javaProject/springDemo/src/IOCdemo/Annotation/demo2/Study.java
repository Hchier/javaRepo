package IOCdemo.Annotation.demo2;

import org.springframework.stereotype.Component;

@Component(value = "name_is_study")
public class Study {
    public void study(){
        System.out.println("study");
    }
}
