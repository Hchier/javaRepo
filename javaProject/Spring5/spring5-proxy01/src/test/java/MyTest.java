import config.Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojo.Service;
import pojo.ServiceImpl;
import pojo.ServiceProxy;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
        ServiceImpl serviceImpl = context.getBean("ServiceImpl", ServiceImpl.class);
        ServiceProxy serviceProxy = context.getBean("ServiceProxy", ServiceProxy.class);
        serviceProxy.setService(serviceImpl);
        serviceProxy.add();
    }
}
