package IOCdemo.demo4_collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    List<Course> courses;
    List<String> list;
    Map<String, String> map;
    Set<String> set;

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

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Set<String> getSet() {
        return set;
    }
}
