package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pojo.Cat;
import pojo.User;

@Configuration
@ComponentScan("pojo")
@Scope("prototype")
public class Config {
    //注册一个bean，相当于之前的bean标签
//    @Bean
//    public User user(){
//        //返回要注册到bean中的对象
//        return new User();
//    }
//
//    @Bean
//    public Cat cat(){
//        return new Cat();
//    }
}
