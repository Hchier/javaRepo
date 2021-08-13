package org.hzero.todo.infra.mapper;
import java.util.List;
import io.choerodon.mybatis.common.BaseMapper;
import io.choerodon.swagger.annotation.Permission;
import org.hzero.todo.domain.entity.Task;
import org.springframework.stereotype.Component;

/**
 * TaskMapper
 */
@Component
public interface TaskMapper extends BaseMapper<Task> {
    /**
     * 查询任务
     *
     * @param params 任务查询参数
     * @return Task
     */
    @Permission
    List<Task> selectTask(Task params);
}