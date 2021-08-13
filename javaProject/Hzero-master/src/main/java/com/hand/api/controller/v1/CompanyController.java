package com.hand.api.controller.v1;

import com.hand.config.SwaggerApiConfig;
import io.swagger.annotations.Api;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import com.hand.domain.entity.Company;
import com.hand.domain.repository.CompanyRepository;
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

/**
 *  管理 API
 *
 * @author sh1101315853@163.com 2020-07-27 15:21:08
 */
@Api(tags = SwaggerApiConfig.COMPANY)
@RestController("companySiteController.v1")
@RequestMapping("/v1/companys")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyRepository companyRepository;

    @ApiOperation(value = "列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<Page<Company>> list(Company company, @ApiIgnore @SortDefault(value = Company.FIELD_COMPANY_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Company> list = companyRepository.pageAndSort(pageRequest, company);
        return Results.success(list);
    }

    @ApiOperation(value = "明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{companyId}")
    public ResponseEntity<Company> detail(@PathVariable Long companyId) {
        Company company = companyRepository.selectByPrimaryKey(companyId);
        return Results.success(company);
    }

    @ApiOperation(value = "创建")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<Company> create(@RequestBody Company company) {
        validObject(company);
        companyRepository.insertSelective(company);
        return Results.success(company);
    }

    @ApiOperation(value = "修改")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<Company> update(@RequestBody Company company) {
        SecurityTokenHelper.validToken(company);
        companyRepository.updateByPrimaryKeySelective(company);
        return Results.success(company);
    }

    @ApiOperation(value = "删除")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Company company) {
        SecurityTokenHelper.validToken(company);
        companyRepository.deleteByPrimaryKey(company);
        return Results.success();
    }

}
