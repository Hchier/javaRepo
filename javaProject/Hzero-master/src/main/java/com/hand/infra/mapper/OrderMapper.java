package com.hand.infra.mapper;

import com.hand.api.controller.dto.OrderReturnDTO;
import com.hand.domain.entity.Conditions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 订单查询
 */
@Component
public interface OrderMapper {
    /**
     * 条件查询订单汇总的数据
     * @param conditions 条件实体类
     * @return 订单汇总的数据
     **/
    List<OrderReturnDTO> list(Conditions conditions);

}
