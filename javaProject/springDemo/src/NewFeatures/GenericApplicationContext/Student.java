package NewFeatures.GenericApplicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Student {
    public void eat(){
        System.out.println("eat");
    }
}

class Main{
    public static void main(String[] args) {
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("NewFeatures/GenericApplicationContext/bean.xml");
//        Student student=applicationContext.getBean("student",Student.class);
        //函数式风格创建对象，交给spring管理
        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        genericApplicationContext.refresh();
        genericApplicationContext.registerBean("student",Student.class,() -> new Student());
        Student student=genericApplicationContext.getBean("student",Student.class);
        student.eat();
    }
}
