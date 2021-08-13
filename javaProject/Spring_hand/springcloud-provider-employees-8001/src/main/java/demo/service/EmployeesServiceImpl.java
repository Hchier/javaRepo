package demo.service;

import demo.mapper.EmployeesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pojo.hand_employees;

import java.util.List;

@Component
public class EmployeesServiceImpl implements EmployeesService {
    @Autowired
    private EmployeesMapper employeesMapper;

    @Override
    public void addEmployees(hand_employees employees) {
        employeesMapper.addEmployees(employees);
    }

    @Override
    public List<hand_employees> selectAll() {
        return employeesMapper.selectAll();
    }
}
