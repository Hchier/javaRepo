package com.hand.infra.repository.impl;

import com.hand.infra.mapper.CompanyMapper;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import com.hand.domain.entity.Company;
import com.hand.domain.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company> implements CompanyRepository {
    @Autowired
    CompanyMapper companyMapper;
    @Override
    public List<Company> selectByNum(String company_number) {
        return companyMapper.selectByNum(company_number);
    }

    @Override
    public void deleteById(Long company_id) {
        companyMapper.deleteById(company_id);
    }
}
