package demo.service;

import demo.mapper.DepartmentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pojo.Update;
import pojo.hand_departments;

import java.util.List;

@Component
public class DepartmentsServiceImpl implements DepartmentsService{
    @Autowired
    private DepartmentsMapper departmentsMapper;
    @Override
    public void addDepartments(hand_departments departments) {
        departmentsMapper.addDepartments(departments);
    }

    @Override
    public hand_departments selectById(String department_id) {
        return departmentsMapper.selectById(department_id);
    }

    @Override
    public List<hand_departments> selectAll() {
        return departmentsMapper.selectAll();
    }

    @Override
    public void update(Update update) {

    }
}
