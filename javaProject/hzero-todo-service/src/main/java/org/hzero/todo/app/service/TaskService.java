package org.hzero.todo.app.service;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import org.hzero.todo.domain.entity.Task;

/**
 * 任务应用服务
 */

public interface TaskService {
    /**
     * 创建任务
     *
     * @param task 任务
     * @return Task
     */
    @Permission
    Task create(Task task);

    /**
     * 更新任务
     *
     * @param task 任务
     * @return Task
     */
    @Permission
    Task update(Task task);

    /**
     * 根据任务编号删除
     *
     * @param taskNumber 任务编号
     */
    @Permission
    void deleteByTaskNumber(String taskNumber);
}