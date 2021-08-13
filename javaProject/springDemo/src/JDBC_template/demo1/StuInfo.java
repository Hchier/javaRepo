package JDBC_template.demo1;

import java.util.List;

public class StuInfo {
    String name;
    int age;
    List<Object[]> batchArgs;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public List<Object[]> getBatchArgs() {
        return batchArgs;
    }

    public void setBatchArgs(List<Object[]> batchArgs) {
        this.batchArgs = batchArgs;
    }

    @Override
    public String toString() {
        return "StuInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
