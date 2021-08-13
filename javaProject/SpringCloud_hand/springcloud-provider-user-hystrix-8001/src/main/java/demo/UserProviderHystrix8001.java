package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient//自动在服务启动后注册到eure中
@EnableCircuitBreaker //添加对熔断的支持
public class UserProviderHystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderHystrix8001.class,args);
    }
}