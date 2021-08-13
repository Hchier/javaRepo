import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.NameSpaceC;
import pojo.NameSpaceP;
import pojo.Student;

public class MyTest {
    @Test
    public void student(){
        ApplicationContext context= new ClassPathXmlApplicationContext("StudentBeans.xml");
        Student student = (Student) context.getBean("Student");
        System.out.println(student.toString());
    }

    @Test
    public void namespace_p(){
        ApplicationContext context=new ClassPathXmlApplicationContext("NameSpaceP_beans.xml");
        NameSpaceP nameSpaceP = context.getBean("nameSpaceP", NameSpaceP.class);
        System.out.println(nameSpaceP.toString());
    }
    @Test
    public void namespace_c(){
        ApplicationContext context=new ClassPathXmlApplicationContext("NameSpaceC_beans.xml");
        NameSpaceC nameSpaceC = context.getBean("nameSpaceC", NameSpaceC.class);
        System.out.println(nameSpaceC.toString());
    }
}
