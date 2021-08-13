package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class MyAnnotation02 {
    @Annotation02(name = "Hchier")
    public void test1() {

    }
}

@Target({ElementType.METHOD, ElementType.TYPE})
@interface Annotation02 {
    //注解的参数：参数类型 + 参数名()
    String name() default "";
}