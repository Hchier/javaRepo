package demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.service.EmployeesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.Update;
import pojo.User;
import pojo.hand_employees;

import java.util.List;

//提供restful服务
@ConfigurationProperties(prefix = "spring")
@RestController
public class EmployeesController {
    @Autowired
    private EmployeesServiceImpl employeesService;

    @ResponseBody
    @RequestMapping("/employees/add/{id1}/{num}/{first_name}/{last_name}/{sex}/{phone_num}/{email}/{hire_date}/{department_id}/{status_code}")
    public String addEmployees(@PathVariable String id1, @PathVariable String num, @PathVariable String first_name,
                             @PathVariable String last_name, @PathVariable String sex, @PathVariable String phone_num,
                             @PathVariable String email, @PathVariable String hire_date, @PathVariable String department_id,
                             @PathVariable String status_code) {
        System.out.println(id1+ num+ first_name+ last_name+ sex+ phone_num+ email+ hire_date+ department_id+ status_code);
        hand_employees employees = new hand_employees(id1, num, first_name, last_name, sex, phone_num, email,
                                                      hire_date, department_id, status_code);
        //employees.setEmployee_id(id);
        System.out.println(employees.toString());
        employeesService.addEmployees(employees);
        return "add: "+employees.toString()+" success!!!!!!!!!!!!!!";
    }

    @RequestMapping("/employees/selectall")
    public List<hand_employees> selectAll() {
        return employeesService.selectAll();
    }

    //失败了调用方法selectByNameHystrix
    @HystrixCommand(fallbackMethod = "selectByIdHystrix")
    @RequestMapping("/employees/selectbyid/{employee_id}")
    public hand_employees selectById(@PathVariable String employee_id) {
        hand_employees employees= employeesService.selectById(employee_id);
        if(employees==null){
            throw new RuntimeException();//出现异常，调用方法selectByIdHystrix
        }
        return employees;
    }
    public User selectByIdHystrix(){
        User user=new User();
        user.setUsername("查无此人@Hystrix");
        return user;
    }
    @ResponseBody
    @RequestMapping("/employees/update/{table}/{column}/{result}/{shackles}")
    // update #{table} set #{column}=#{result} where employee_id = #{shackles}
    public String update(@PathVariable String table,@PathVariable String column, @PathVariable String result,@PathVariable String shackles) {
        Update update=new Update(table,column,result,shackles);
        System.out.println(update.toString());
        employeesService.update(update);
        return "update success";
    }
}
