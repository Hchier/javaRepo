package demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.hand_employees;

import java.util.List;


@Repository
@Mapper
public interface EmployeesMapper {
    public void addEmployees(hand_employees employees);
    public List<hand_employees> selectAll();
}
