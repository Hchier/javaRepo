package demo.service;

import pojo.Update;
import pojo.hand_departments;

import java.util.List;

public interface DepartmentsService {
    public void addDepartments(hand_departments departments);
    public hand_departments selectById(String department_id);
    public List<hand_departments> selectAll();
    public void update(Update update);
}
