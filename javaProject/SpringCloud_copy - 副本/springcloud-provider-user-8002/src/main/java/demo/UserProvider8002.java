package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient//自动在服务启动后注册到eure中
public class UserProvider8002 {
    public static void main(String[] args) {
        SpringApplication.run(UserProvider8002.class,args);
    }
}