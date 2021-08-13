package com.hand.infra.mapper;

import com.hand.domain.entity.Customer;
import io.choerodon.mybatis.common.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * Mapper
 *
 * @author sh1101315853@163.com 2020-07-27 15:21:08
 */
@Repository
public interface CustomerMapper extends BaseMapper<Customer> {

}
