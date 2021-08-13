package IOCdemo.Annotation.pureAnnotation;

import org.springframework.stereotype.Component;

@Component
public class Study {
    public void study(){
        System.out.println("study");
    }
}
