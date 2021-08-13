package com.hand.infra.mapper;

import com.hand.domain.entity.Company;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
//@Mapper
public interface CompanyMapper extends BaseMapper<Company> {
    public List<Company> selectByNum(String company_number);
    public void deleteById(Long company_id);
}
