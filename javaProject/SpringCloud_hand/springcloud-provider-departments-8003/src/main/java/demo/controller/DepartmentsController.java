package demo.controller;//package demo.controller;

import demo.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.Update;
import pojo.hand_departments;

import java.util.List;

//提供restful服务
@ConfigurationProperties(prefix = "spring")
@RestController
public class DepartmentsController {
    @Autowired
    private DepartmentsService departmentsService;

    @ResponseBody
    @RequestMapping("/departments/add/{department_id}/{department_code}/{department_name}/{manager_id}/{location_id}")
    public String addEmployees(@PathVariable String department_id, @PathVariable String department_code,
                               @PathVariable String department_name, @PathVariable String manager_id,
                               @PathVariable String location_id) {
        System.out.println();
        hand_departments departments = new hand_departments(department_id, department_code, department_name, manager_id, location_id);
        //employees.setEmployee_id(id);
        System.out.println(departmentsService.toString());
        departmentsService.addDepartments(departments);
        return "add: " + departments.toString() + " success!!!!!!!!!!!!!!";
    }

    @RequestMapping("/departments/selectall")
    public List<hand_departments> selectAll() {
        return departmentsService.selectAll();
    }

    @RequestMapping("/departments/selectbyid/{department_id}")
    public hand_departments selectById(@PathVariable String department_id) {
        return departmentsService.selectById(department_id);
    }

    @ResponseBody
    @RequestMapping("/departments/update/{table}/{column}/{result}/{shackles}")
    // update #{table} set #{column}=#{result} where employee_id = #{shackles}
    public String update(@PathVariable String table, @PathVariable String column, @PathVariable String result, @PathVariable String shackles) {
        Update update = new Update(table, column, result, shackles);
        System.out.println(update.toString());
        departmentsService.update(update);
        return "update success";
    }
}
