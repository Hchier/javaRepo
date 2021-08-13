package IOCdemo.demo3;

public class Employee {
    String name;
    String age;
    //one employee belongs to one department while one department could have n-employee
    Department department;

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }
}
