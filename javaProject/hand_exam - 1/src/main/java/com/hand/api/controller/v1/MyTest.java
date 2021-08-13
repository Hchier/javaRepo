package com.hand.api.controller.v1;

import com.hand.domain.entity.Company;
import com.hand.domain.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MyTest {
    @Autowired
    static private CompanyRepository companyRepository;

    public static void main(String[] args) {
        Company company = companyRepository.selectByPrimaryKey(1);
        System.out.println(company);
    }
}
