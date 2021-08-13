package IOCdemo.demo2.getPerson;

import IOCdemo.demo2.Person.Person;

public class GetPerson {
    String name;
    Person person1 = new Person();

    public void setPerson1(Person person) {
        this.person1 = person;
    }

    public void getPerson1() {
        person1.print();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getName() {
        System.out.println(name);
    }
}
