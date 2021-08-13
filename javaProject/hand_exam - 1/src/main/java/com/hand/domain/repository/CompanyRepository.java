package com.hand.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hand.domain.entity.Company;

import java.util.List;


public interface CompanyRepository extends BaseRepository<Company> {
    public List<Company> selectByNum(String company_number);
    public void deleteById(Long company_id);
}
