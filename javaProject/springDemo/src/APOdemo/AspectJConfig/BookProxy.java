package APOdemo.AspectJConfig;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookProxy {
    public void before(){
        System.out.println("before");
    }
}

class Main{
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("APOdemo/AspectJConfig/bean.xml");
        Book book=applicationContext.getBean("book",Book.class);
        book.buy();
    }
}