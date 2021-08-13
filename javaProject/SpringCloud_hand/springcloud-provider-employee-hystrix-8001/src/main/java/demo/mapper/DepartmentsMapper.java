package demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Update;
import pojo.hand_departments;

import java.util.List;

@Repository
@Mapper
public interface DepartmentsMapper {
    public void addDepartments(hand_departments departments);
    public hand_departments selectById(String department_id);
    public List<hand_departments> selectAll();
    public void update(Update update);
}
