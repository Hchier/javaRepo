package APOdemo.AspectJAnnotationDemo1;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"APOdemo.AspectJAnnotationDemo1"})
public class Config {
}
