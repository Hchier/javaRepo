package springcloud.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean { //相当于spring里面的applicationContext.xml  配bean
    //IRule 负载均衡策略
    //RoundRobinRule  轮询
    //RandomRule  随机
    //AvailiablityFilteringRule  先过滤掉故障服务
    //RetryRule 先轮询，若服务获取失败，则在指定时间类重试
    @Bean
    @LoadBalanced  //ribbon //配置负载均衡实现template
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
