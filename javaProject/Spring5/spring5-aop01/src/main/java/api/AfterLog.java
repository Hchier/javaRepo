package api;


import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Component("AfterLog")
public class AfterLog implements AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("原生api："+o1.getClass().getName()+"的"+method.getName()+"方法执行后");
    }
}
