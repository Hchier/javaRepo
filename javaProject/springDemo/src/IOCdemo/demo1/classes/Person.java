package IOCdemo.demo1.classes;

public class Person {
    String name;
    String age;
    String telephonenumber;
    Person(String name, String age, String telephonenumber) {
        this.age = age;
        this.name = name;
        this.telephonenumber=telephonenumber;
    }

    public void getName() {
        System.out.println("name:" + this.name);
    }

    public void getAge() {
        System.out.println("age:" + this.age);
    }
    public void getTelephonenumber() {
        System.out.println("telephonenumber:" + this.telephonenumber);
    }
}
