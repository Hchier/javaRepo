package com.hand.infra.repository.impl;

import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import com.hand.domain.entity.Customer;
import com.hand.domain.repository.CustomerRepository;
import org.springframework.stereotype.Component;

/**
 *  资源库实现
 *
 * @author sh1101315853@163.com 2020-07-27 15:21:08
 */
@Component
public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer> implements CustomerRepository {

  
}
