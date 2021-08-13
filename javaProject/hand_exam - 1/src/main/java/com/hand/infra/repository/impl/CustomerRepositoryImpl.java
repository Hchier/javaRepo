package com.hand.infra.repository.impl;

import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import com.hand.domain.entity.Customer;
import com.hand.domain.repository.CustomerRepository;
import org.springframework.stereotype.Component;


@Component
public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer> implements CustomerRepository {

  
}
