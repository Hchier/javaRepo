package demo.controller;

import demo.service.EmployeesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.hand_employees;
import java.util.List;

//提供restful服务
@ConfigurationProperties(prefix="spring")
@RestController
public class EmployeesController {
    @Autowired
    private EmployeesServiceImpl employeesService;
    @RequestMapping("/employees/selectall")
    public List<hand_employees> selectAll(){
        return employeesService.selectAll();
    }

}
