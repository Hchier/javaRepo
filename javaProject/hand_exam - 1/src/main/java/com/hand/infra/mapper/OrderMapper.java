package com.hand.infra.mapper;

import com.hand.api.controller.dto.OrderReturnDTO;
import com.hand.domain.entity.Condition;
import com.hand.domain.entity.Conditions;
import com.hand.domain.entity.OrderSummaryQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单查询
 */
@Component
@Repository
public interface OrderMapper {
    /**
     * 条件查询订单汇总的数据
     * @param conditions 条件实体类
     * @return 订单汇总的数据
     **/
    List<OrderReturnDTO> list(Conditions conditions);

    public List<OrderSummaryQuery> orderSummaryQuery(Condition condition);
}
