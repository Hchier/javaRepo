package IOCdemo.demo1;
import IOCdemo.demo1.classes.Book;
import IOCdemo.demo1.classes.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Test {
    //通过set注入参数
    public void book(){
        ApplicationContext applicationContext
                =new ClassPathXmlApplicationContext("IOCdemo/demo1/bean.xml");
        Book book=applicationContext.getBean("book",Book.class);
        book.getAuthor();
        book.getName();
    }

    //通过有参构造
    public void person(){
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("IOCdemo/demo1/bean.xml");
        Person person = applicationContext.getBean("person", Person.class);
        person.getAge();
        person.getName();
        person.getTelephonenumber();
    }
}

class Main{
    public static void main(String[] args) {
        Test test=new Test();
        test.book();
        test.person();
    }
}