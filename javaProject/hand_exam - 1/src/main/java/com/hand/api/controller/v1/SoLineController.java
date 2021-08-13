package com.hand.api.controller.v1;

import com.hand.config.SwaggerApiConfig;
import com.hand.domain.entity.SoHeader;
import io.swagger.annotations.Api;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.hand.domain.entity.SoLine;
import com.hand.domain.repository.SoLineRepository;
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

import java.util.List;


@Api(tags = SwaggerApiConfig.SOLINE)
@RestController("soLineSiteController.v1")
//@RequestMapping("/v1/so-lines")
public class SoLineController extends BaseController {

    @Autowired
    private SoLineRepository soLineRepository;

//    @ApiOperation(value = "订单行查询API")
//    @Permission(level = ResourceLevel.SITE)
//    @GetMapping("/v1/{organizationId}/so-lines")
//    public ResponseEntity<List<SoLine>> selectByEntityHeaderId(@PathVariable Long organizationId,@RequestBody SoHeader soHeader) {
//        return Results.success(soLineRepository.selectBySoHeaderId(soHeader.getSoHeaderId()));
//    }
//
//    @ApiOperation(value = "订单行删除API")
//    @Permission(level = ResourceLevel.SITE)
//    @DeleteMapping("/v1/{organizationId}/so-lines")
//    public ResponseEntity<?> deleteByEntityId(@PathVariable Long organizationId,@RequestBody SoLine soLine) {
//        soLineRepository.deleteById(soLine.getSoLineId());
//        return Results.success("删除成功");
//    }

    @ApiOperation(value = "订单行查询API（根据so_header_id查询）")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/{organizationId}/so-lines")
    //public ResponseEntity<List<SoLine>> selectByHeaderId(@PathVariable("organizationId") Long organizationId,Long so_header_id) {
    public ResponseEntity<List<SoLine>> selectByHeaderId(@PathVariable Long organizationId, Long so_header_id) {
        System.out.println("so_header_id:"+so_header_id);
        return Results.success(soLineRepository.selectBySoHeaderId(so_header_id));
    }

    @ApiOperation(value = "订单行删除API（根据so_line_id删除）")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping("/v1/{organizationId}/so-lines")
    public ResponseEntity<?> deleteById(@PathVariable("organizationId") Long organizationId,Long so_liner_id) {
        System.out.println("so_liner_id:"+so_liner_id);
        soLineRepository.deleteById(so_liner_id);
        return Results.success("删除成功");
    }


    @ApiOperation(value = "列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/so-lines")
    public ResponseEntity<Page<SoLine>> list(SoLine soLine, @ApiIgnore @SortDefault(value = SoLine.FIELD_SO_LINE_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<SoLine> list = soLineRepository.pageAndSort(pageRequest, soLine);
        return Results.success(list);
    }

//    @ApiOperation(value = "明细")
//    @Permission(level = ResourceLevel.SITE)
//    @GetMapping("/{soLineId}")
//    public ResponseEntity<SoLine> detail(@PathVariable Long soLineId) {
//        SoLine soLine = soLineRepository.selectByPrimaryKey(soLineId);
//        return Results.success(soLine);
//    }

    @ApiOperation(value = "创建")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping("/v1/so-lines")
    public ResponseEntity<SoLine> create(@RequestBody SoLine soLine) {
        validObject(soLine);
        soLineRepository.insertSelective(soLine);
        return Results.success(soLine);
    }

    @ApiOperation(value = "修改")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping("/v1/so-lines")
    public ResponseEntity<SoLine> update(@RequestBody SoLine soLine) {
        //SecurityTokenHelper.validToken(soLine);
        soLineRepository.updateByPrimaryKeySelective(soLine);
        return Results.success(soLine);
    }

    @ApiOperation(value = "根据entity删除")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping("/v1/so-lines")
    public ResponseEntity<?> remove(@RequestBody SoLine soLine) {
        //SecurityTokenHelper.validToken(soLine);
        soLineRepository.deleteByPrimaryKey(soLine);
        return Results.success();
    }


    @ApiOperation(value = "查询所有订单行")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/so-lines/selectAll")
    public ResponseEntity<List<SoLine>> selectAll() {

        return Results.success(soLineRepository.selectAllInfo());
    }

    @ApiOperation(value = "根据ID查询订单行")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/so-lines/selectById/{so_line_id}")
    public ResponseEntity<List<SoLine>> selectById(@PathVariable Long so_line_id) {
        return Results.success(soLineRepository.selectById(so_line_id));
    }



    @ApiOperation(value = "根据so_header_id删除")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/so-lines/deleteByHeaderId/{so_header_id}")
    public ResponseEntity<?> deleteByHeaderId(@PathVariable Long so_header_id) {
        soLineRepository.deleteById(so_header_id);
        return Results.success("");
    }


}
