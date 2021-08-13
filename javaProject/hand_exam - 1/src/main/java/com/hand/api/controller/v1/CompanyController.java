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

import java.util.List;


@Api(tags = SwaggerApiConfig.COMPANY)
@RestController()
//@RequestMapping("/v1/companys")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyRepository companyRepository;

    @ApiOperation(value = "列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/companys")
    public ResponseEntity<Page<Company>> list(Company company, @ApiIgnore @SortDefault(value = Company.FIELD_COMPANY_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Company> list = companyRepository.pageAndSort(pageRequest, company);
        return Results.success(list);
    }

//    @ApiOperation(value = "根据公司ID查询")
//    @Permission(level = ResourceLevel.SITE)
//    @GetMapping("/v1/companys/selectById/{companyId}")
//    public ResponseEntity<Company> detail(@PathVariable Long companyId) {
//        Company company = companyRepository.selectByPrimaryKey(companyId);
//        System.out.println("companyRepository.selectByPrimaryKey(companyId)");
//        return Results.success(company);
//    }

    @ApiOperation(value = "根据公司ID查询")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/{organizationId}/companys")
    public ResponseEntity<Company> detail(@PathVariable("organizationId") Long organizationId,Long companyId) {
        Company company = companyRepository.selectByPrimaryKey(companyId);
        System.out.println("companyRepository.selectByPrimaryKey(companyId)");
        return Results.success(company);
    }

    @ApiOperation(value = "根据公司NUM查询")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/companys/selectByNum/{companyNumber}")
    public ResponseEntity<List<Company>> detail2(@PathVariable String companyNumber) {
        List<Company> company = companyRepository.selectByNum(companyNumber);
        System.out.println("companyRepository.selectByNum(companyNumber)");
        return Results.success(company);
    }


    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/companys/test")
    public String test1() {
        return "for testing from Hchier";
    }




    @ApiOperation(value = "创建")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping("/v1/companys")
    public ResponseEntity<Company> create(@RequestBody Company company) {
        validObject(company);
        companyRepository.insertSelective(company);
        return Results.success(company);
    }

    @ApiOperation(value = "修改")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping("/v1/companys")
    public ResponseEntity<Company> update(@RequestBody Company company) {
        //SecurityTokenHelper.validToken(company);
        companyRepository.updateByPrimaryKeySelective(company);
        return Results.success(company);
    }

    @ApiOperation(value = "根据entity删除")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping("/v1/companys")
    public ResponseEntity<?> remove(@RequestBody Company company) {
        //SecurityTokenHelper.validToken(company);
        companyRepository.deleteByPrimaryKey(company);
        return Results.success("");
    }

    @ApiOperation(value = "根据id删除")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/companys/deleteById/{companyId}")
    public ResponseEntity<?> deleteById(@PathVariable Long companyId) {
        companyRepository.deleteById(companyId);
        return Results.success("");
    }

}
