package APOdemo.AspectJAnnotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//  开启扫描注解
@ComponentScan(basePackages = {"APOdemo.AspectJAnnotation"})
//开启aspect生成代理对象
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config {
}
