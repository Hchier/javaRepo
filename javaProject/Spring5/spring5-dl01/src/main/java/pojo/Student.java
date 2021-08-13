package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Setter
@Getter
@ToString
public class Student {
    String name;
    String age;
    Computer computer;
    String[] array;
    List<String> list;
    Set<String> set;
    Map<String, String> map;
    Properties properties;
}
