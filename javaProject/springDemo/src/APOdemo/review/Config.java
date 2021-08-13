package APOdemo.review;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "APOdemo.review")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config {
}
