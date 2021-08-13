package demo.service;


import pojo.Update;
import pojo.hand_employees;

import java.util.List;

public interface EmployeesService {
    public void addEmployees(hand_employees employees);
    public hand_employees selectById(String employee_id);
    public List<hand_employees> selectAll();
    public void update(Update update);
}
