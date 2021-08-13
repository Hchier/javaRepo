package springcloud;

//import myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient  //让eureka生效
//在微服务启动时就加载自定义ribbon类
//@RibbonClient(name="SPRINGCLOUD-PROVIDER-USER",configuration = MyRule.class)
public class UserConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumer_80.class, args);
    }
}
