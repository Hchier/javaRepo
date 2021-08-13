package IOCdemo.demo5_extract_injection;

import java.util.List;


public class Student {
    List<Course> courses;
    List<String> list;

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }


    public void setList(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }
}
