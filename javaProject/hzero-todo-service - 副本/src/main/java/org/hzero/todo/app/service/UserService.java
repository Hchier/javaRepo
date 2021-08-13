package org.hzero.todo.app.service;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import org.hzero.todo.domain.entity.User;
/**
 * 用户应用服务
 */
//@Permission(level = ResourceLevel.SITE, permissionLogin=false, permissionPublic=false)
public interface UserService {
    /**
     * 创建用户
     *
     * @param user User
     * @return User
     */
    @Permission
    User create(User user);
    /**
     * 删除用户(同时删除任务)
     *
     * @param userId 用户ID
     */
    @Permission
    void delete(Long userId);
}