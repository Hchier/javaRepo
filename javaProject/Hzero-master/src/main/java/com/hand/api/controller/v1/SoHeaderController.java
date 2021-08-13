package com.hand.api.controller.v1;

import com.hand.api.utils.PrincipalUtil;
import com.hand.app.service.SoHeaderService;
import com.hand.config.SwaggerApiConfig;
import io.choerodon.core.oauth.CustomUserDetails;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.swagger.annotations.Api;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.hand.domain.entity.SoHeader;
import com.hand.domain.repository.SoHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.hzero.mybatis.helper.SecurityTokenHelper;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.Version;
import java.security.Principal;

/**
 * 管理 API
 *
 * @author sh1101315853@163.com 2020-07-27 15:21:08
 */
@Api(tags = SwaggerApiConfig.SOHEADGER)
@RestController("soHeaderSiteController.v1")
@RequestMapping("/v1/so-headers")
public class SoHeaderController extends BaseController {

    @Autowired
    private SoHeaderService soHeaderService;

    @Autowired
    private SoHeaderRepository soHeaderRepository;

    @Autowired
    private CodeRuleBuilder codeRuleBuilder;

    private final String ORDERNUMBER = "HZERO.28263.ORDER.NUMBER";

    @ApiOperation(value = "列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<Page<SoHeader>> list(SoHeader soHeader, @ApiIgnore @SortDefault(value = SoHeader.FIELD_SO_HEADER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<SoHeader> list = soHeaderRepository.pageAndSort(pageRequest, soHeader);
        return Results.success(list);
    }

    @ApiOperation(value = "明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{soHeaderId}")
    public ResponseEntity<SoHeader> detail(@PathVariable Long soHeaderId) {
        SoHeader soHeader = soHeaderRepository.selectByPrimaryKey(soHeaderId);
        return Results.success(soHeader);
    }

    @ApiOperation(value = "创建")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<SoHeader> create(@RequestBody SoHeader soHeader) {
        validObject(soHeader);
        String code = codeRuleBuilder.generateCode(ORDERNUMBER, null);
        soHeader.setOrderNumber(code);
        soHeaderRepository.insertSelective(soHeader);
        return Results.success(soHeader);
    }

    /**
     * 修改订单状态
     * @param soHeader
     * @param principal
     * @return
     */
    @ApiOperation(value = "修改")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<String> update(@RequestBody SoHeader soHeader, Principal principal) {
        return soHeaderService.updateStatus(soHeader, principal);
    }


    @ApiOperation(value = "删除")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody SoHeader soHeader) {
        SecurityTokenHelper.validToken(soHeader);
        soHeaderRepository.deleteByPrimaryKey(soHeader);
        return Results.success();
    }

}
