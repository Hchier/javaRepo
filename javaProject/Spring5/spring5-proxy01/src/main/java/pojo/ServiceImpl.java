package pojo;

import org.springframework.stereotype.Component;

@Component("ServiceImpl")
public class ServiceImpl implements Service {
    public void add() {
        System.out.println("add");
    }

    public void delete() {
        System.out.println("delete");
    }
}
