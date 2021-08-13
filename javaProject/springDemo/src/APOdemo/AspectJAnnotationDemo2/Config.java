package APOdemo.AspectJAnnotationDemo2;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"APOdemo.AspectJAnnotationDemo2"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config {
}
