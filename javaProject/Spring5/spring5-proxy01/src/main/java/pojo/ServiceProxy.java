package pojo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component("ServiceProxy")

public class ServiceProxy implements Service{
    ServiceImpl service;

    public void setService(ServiceImpl service) {
        this.service = service;

    }

    public void add() {
        log("add");
        service.add();
    }

    public void delete() {
        log("delete");
        service.delete();
    }

    public void log(String message){
        System.out.println(message);
    }
}
