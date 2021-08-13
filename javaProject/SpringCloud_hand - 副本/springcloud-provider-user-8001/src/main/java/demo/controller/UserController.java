package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.hand_employees;
import demo.service.EmployeesServiceImpl;

import java.util.List;

//提供restful服务
@ConfigurationProperties(prefix="spring")
@RestController
public class UserController {
    @Autowired
    private EmployeesServiceImpl employeesService;
    @RequestMapping("/employees/add")
    public void addEmployees(hand_employees employees){
        employeesService.addEmployees(employees);
    }
//    @RequestMapping("/user/select/{name}")
//    public User selectByName(@PathVariable String name){
//        return employeesService.selectByName(name);
//    }
    @RequestMapping("/employees/selectall")
    public List<hand_employees> selectAll(){
        return employeesService.selectAll();
    }
}
