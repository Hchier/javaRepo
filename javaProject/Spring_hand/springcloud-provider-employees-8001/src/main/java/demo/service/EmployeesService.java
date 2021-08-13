package demo.service;

import pojo.hand_employees;

import java.util.List;

public interface EmployeesService {
    public void addEmployees(hand_employees employees);
    public List<hand_employees> selectAll();
}
