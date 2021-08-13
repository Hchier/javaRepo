package org.hzero.todo.infra.repository.impl;
import org.springframework.stereotype.Component;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.todo.domain.entity.User;
import org.hzero.todo.domain.repository.UserRepository;
/**
 * 用户资源库实现
 */
@Component
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {
}