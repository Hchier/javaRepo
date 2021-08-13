package com.hand.app.remote;

import com.hand.app.remote.fallback.RemoteRoleServiceFallback;
import org.hzero.iam.domain.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "hzero-iam", fallback = RemoteRoleServiceFallback.class)
public interface RemoteRoleService {

    @GetMapping({"/hzero/v1/{organizationId}/roles/{roleId}"})
    Role queryRoleDetails(@PathVariable("organizationId") Long organizationId, @PathVariable Long roleId);
}
