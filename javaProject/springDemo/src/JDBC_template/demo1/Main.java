package JDBC_template.demo1;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("JDBC_template/demo1/bean.xml");
        Student student = applicationContext.getBean("student1", Student.class);

        StuInfo stuInfo = new StuInfo();
        stuInfo.setName("Hchier");
        stuInfo.setAge(18);
        //System.out.println(student.add(stuInfo));
        //System.out.println(student.delete());
        //语句+需要返回的类型           查询表中有数据几条
        //System.out.println("selectCount:"+student.selectCount());
        //查询返回对象（返回  一  条记录的多个值，放在Stuinfo中）
        //System.out.println(student.getStuInfo());
        ///查询返回对象集合（返回  多  条记录的多个值，放在Stuinfo中）
        //System.out.println(student.getStuInfos());

//        //插入多条数据
//        List<Object[]> batchArgs=new ArrayList<>();
//        Object[] obj1 = {11, 11};
//        Object[] obj2 = {22, 22};
//        Object[] obj3 = {33, 33};
//        batchArgs.add(obj1);
//        batchArgs.add(obj2);
//        batchArgs.add(obj3);
//        System.out.println("student.insert(batchArgs):" + student.inserts(batchArgs));

        // 删除多条数据
        List<Object[]> batchArgs_delete = new ArrayList<>();
        //加                     " "                 !!!!!!!!!!!!!!!!!
        Object[] obj1 = {"11"};
        Object[] obj2 = {"22"};
        batchArgs_delete.add(obj1);
        batchArgs_delete.add(obj2);
        student.deletes(batchArgs_delete);
    }
}
