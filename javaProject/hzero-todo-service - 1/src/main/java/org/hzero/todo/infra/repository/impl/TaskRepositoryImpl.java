package org.hzero.todo.infra.repository.impl;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.mybatis.common.Criteria;
import org.hzero.todo.domain.entity.Task;
import org.hzero.todo.domain.repository.TaskRepository;
import org.hzero.todo.infra.mapper.TaskMapper;
/**
 * 任务资源库实现
 */
@Component
public class TaskRepositoryImpl extends BaseRepositoryImpl<Task> implements TaskRepository {
    private final TaskMapper taskMapper;
    public TaskRepositoryImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }
    @Override
    public Page<Task> pageTask(Task task, PageRequest pageRequest) {
        return PageHelper.doPage(pageRequest, () -> taskMapper.selectTask(task));
    }
    @Override
    public List<Task> selectByEmployeeId(Long employeeId) {
        Task task = new Task();
        task.setEmployeeId(employeeId);
        return this.selectOptional(task, new Criteria()
                .select(Task.FIELD_ID, Task.FIELD_EMPLOYEE_ID, Task.FIELD_STATE, Task.FIELD_TASK_DESCRIPTION)
                .where(Task.FIELD_EMPLOYEE_ID)
        );
    }
    @Override
    public Task selectDetailByTaskNumber(String taskNumber) {
        Task params = new Task();
        params.setTaskNumber(taskNumber);
        List<Task> tasks = taskMapper.selectTask(params);
        return CollectionUtils.isNotEmpty(tasks) ? tasks.get(0) : null;
    }
}