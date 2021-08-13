package annotation;

import java.lang.annotation.*;

@Annotation1
class MyAnnotation01 {

    public void test1(){

    }
}

//Target表明注解使用位置
@Target(value = ElementType.TYPE)
//Retention 表明在什么地方还有效    runtime>class>sources。若为runtime，则在class和sources还有效
@Retention(value = RetentionPolicy.RUNTIME)
//是否将注解生成在javadoc中
@Documented
//子类可以继承父类的注解
@Inherited
@interface Annotation1{

}