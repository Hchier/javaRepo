package springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean { //相当于spring里面的applicationContext.xml  配bean
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
