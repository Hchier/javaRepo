package com.hand.app.remote.fallback;

import com.hand.app.remote.RemoteRoleService;
import org.apache.ibatis.cache.CacheException;
import org.hzero.iam.domain.entity.Role;


public class RemoteRoleServiceFallback implements RemoteRoleService {
    @Override
    public Role queryRoleDetails(Long organizationId, Long roleId) {
        throw new CacheException("remote call failed");
    }
}
