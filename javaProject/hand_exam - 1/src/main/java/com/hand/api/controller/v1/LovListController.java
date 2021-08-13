package com.hand.api.controller.v1;

import com.hand.config.SwaggerApiConfig;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(SwaggerApiConfig.LOVLIST)
@RestController("lovListController.v1")
@RequestMapping("/v1/{organizationId}/lov")
public class LovListController {


}
