package APOdemo.demo1;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDk_proxy {
    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces = {action.class};
        action action = (action) Proxy.newProxyInstance(JDk_proxy.class.getClassLoader(), interfaces, new Person_proxy(new Person()));
        System.out.println(action.add(1, 1));
    }
}

class Person_proxy implements InvocationHandler {
    //传进被代理的对象
    //
    Object object;

    public Person_proxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before:" + method.getName() + " " + Arrays.toString(args));
        Object result = method.invoke(object, args);


        System.out.println("after:" + method.getName());
        System.out.println("result:" + result);
        return result;
    }
}