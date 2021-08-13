package diy;

import org.springframework.stereotype.Component;

@Component("DiyPointCut")
public class DiyPointCut {
    public void after(){
        System.out.println("DiyAfter");
    }
    public void before(){
        System.out.println("DiyBefore");
    }
}
