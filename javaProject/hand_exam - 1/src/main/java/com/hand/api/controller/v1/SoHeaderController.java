package com.hand.api.controller.v1;

import com.hand.api.controller.dto.OrderReturnDTO;
import com.hand.api.utils.PrincipalUtil;
import com.hand.app.service.SoHeaderService;
import com.hand.config.SwaggerApiConfig;
import com.hand.domain.entity.OrderSummaryQuery;
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
import java.util.List;


@Api(tags = SwaggerApiConfig.SOHEADGER)
@RestController("soHeaderSiteController.v1")
//@RequestMapping("/v1/so-headers")
public class SoHeaderController extends BaseController {

    @Autowired
    private SoHeaderService soHeaderService;

    @Autowired
    private SoHeaderRepository soHeaderRepository;

    @Autowired
    private CodeRuleBuilder codeRuleBuilder;

    @ApiOperation(value = "订单头查询API")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/{organizationId}/so-headers/{soHeaderId}")
    public ResponseEntity<OrderReturnDTO> selectById(@PathVariable Long organizationId, @PathVariable Long soHeaderId) {

        return Results.success(soHeaderRepository.selectById(soHeaderId));
    }

    @ApiOperation(value = "订单状态API")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping("/v1/{organization}/so-headers/operate/{status}")
    public ResponseEntity<String> update(@PathVariable Long organization,@RequestBody SoHeader soHeader, @PathVariable String status, Principal principal) {
        return soHeaderService.updateStatus(soHeader, principal, status);
    }

    @ApiOperation(value = "列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/so-headers")
    public ResponseEntity<Page<SoHeader>> list(SoHeader soHeader, @ApiIgnore @SortDefault(value = SoHeader.FIELD_SO_HEADER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<SoHeader> list = soHeaderRepository.pageAndSort(pageRequest, soHeader);
        return Results.success(list);
    }

    @ApiOperation(value = "明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/so-headers/{soHeaderId}")
    public ResponseEntity<SoHeader> detail(@PathVariable Long soHeaderId) {
        SoHeader soHeader = soHeaderRepository.selectByPrimaryKey(soHeaderId);
        return Results.success(soHeader);
    }

//    @ApiOperation(value = "创建")
//    @Permission(level = ResourceLevel.SITE)
//    @PostMapping
//    public ResponseEntity<SoHeader> create(@RequestBody SoHeader soHeader) {
//        validObject(soHeader);
//        String code = codeRuleBuilder.generateCode(ORDERNUMBER, null);
//        soHeader.setOrderNumber(code);
//        soHeaderRepository.insertSelective(soHeader);
//        return Results.success(soHeader);
//    }

    /**
     * 修改订单状态
     *
     * @param soHeader
     * @param principal
     * @return
     */
//    @ApiOperation(value = "修改")
//    @Permission(level = ResourceLevel.SITE)
//    @PutMapping
//    public ResponseEntity<String> update(@RequestBody SoHeader soHeader, Principal principal) {
//        return soHeaderService.updateStatus(soHeader, principal);
//    }



    @ApiOperation(value = "根据entity删除")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody SoHeader soHeader) {
        //SecurityTokenHelper.validToken(soHeader);
        soHeaderRepository.deleteByPrimaryKey(soHeader);
        return Results.success();
    }

    @ApiOperation(value = "根据id删除")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/so-headers/deleteById/{so_header_id}")
    public ResponseEntity<?> deleteById(@PathVariable Long so_header_id) {
        //SecurityTokenHelper.validToken(so_header_id);
        soHeaderRepository.deleteById(so_header_id);
        return Results.success();
    }




    @ApiOperation(value = "查询所有订单头")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/so-headers/selectAll")
    public ResponseEntity<List<SoHeader>> selectAll() {

        return Results.success(soHeaderRepository.selectAllInfo());
    }


    @ApiOperation(value = "订单汇总查询")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/so-headers/orderSummaryQuery/{companyId}/{customerId}/{orderNumber}/{orderStatus}")
    public ResponseEntity<List<OrderSummaryQuery>> orderSummaryQuery(@PathVariable Long companyId, @PathVariable Long customerId, @PathVariable String orderNumber, @PathVariable String orderStatus) {
        return Results.success(soHeaderRepository.orderSummaryQuery(companyId, customerId, orderNumber, orderStatus));
    }

    @ApiOperation(value = "修改status")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping("/v1/so-headers/status/{id}/{status}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @PathVariable String status) {
        soHeaderRepository.updateStatus(id, status);
        return Results.success("hello");
    }

    @ApiOperation(value = "增加")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping("/v1/so-headers/insertInfo")
    public ResponseEntity<String> insertInfo(@RequestBody SoHeader soHeader) {
//        validObject(soHeader);
//        String code = codeRuleBuilder.generateCode(ORDERNUMBER, null);
//        soHeader.setOrderNumber(code);
        soHeaderRepository.insertInfo(soHeader);

        return Results.success("hello");
    }

//    @ApiOperation(value = "创建")
//    @Permission(level = ResourceLevel.SITE)
//    @PostMapping
//    public ResponseEntity<SoHeader> create(@RequestBody SoHeader soHeader) {
//        validObject(soHeader);
//        String code = codeRuleBuilder.generateCode(ORDERNUMBER, null);
//        soHeader.setOrderNumber(code);
//        soHeaderRepository.insertSelective(soHeader);
//        return Results.success(soHeader);
//    }
}
