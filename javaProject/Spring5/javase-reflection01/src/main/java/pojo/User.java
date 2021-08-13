package pojo;

import lombok.*;
import org.springframework.context.annotation.ComponentScan;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Person {
    String name;

    public void test() {
        System.out.println("Person test");
    }
}

class Teacher extends Person{

}

class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //class 类的创建方式
        //1通过forName
        Class c1 = Class.forName("pojo.Person");
        System.out.println(c1.hashCode());
        //2通过.class
        Class c2 = Person.class;
        System.out.println(c2.hashCode());
        //3通过实例getClass
        Person person = new Person();
        Class c3 = person.getClass();
        System.out.println(c3.hashCode());
        //获取父类
        Class c4 = Class.forName("pojo.Teacher");
        System.out.println(c4.getSuperclass().hashCode());
    }
}

