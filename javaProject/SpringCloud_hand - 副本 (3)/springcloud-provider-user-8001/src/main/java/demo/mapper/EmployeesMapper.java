package demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Update;
import pojo.hand_employees;

import java.util.List;


@Repository
@Mapper
public interface EmployeesMapper {
    public void addEmployees(hand_employees employees);
    public hand_employees selectById(String employee_id);
    public List<hand_employees> selectAll();
    public void update(Update update);

}
