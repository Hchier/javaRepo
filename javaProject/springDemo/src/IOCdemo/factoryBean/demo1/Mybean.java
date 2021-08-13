package IOCdemo.factoryBean.demo1;

import org.springframework.beans.factory.FactoryBean;

public class Mybean implements FactoryBean<Course> {
    //把Mybean.class 换成 Course.class
        //定义的类和返回的类可以不一样
    @Override
    public Course getObject() throws Exception {
        Course course =new Course();
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
