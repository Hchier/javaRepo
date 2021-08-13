package com.hand.app.service;

import com.hand.api.controller.dto.OrderReturnDTO;
import com.hand.domain.entity.Conditions;
import com.hand.domain.entity.Order;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderService {
    /**
     * 条件分页查询订单汇总的数据
     * @param conditions 条件实体类
     * @return 分页以后的数据
     **/
    Page<OrderReturnDTO> list(PageRequest pageRequest, Conditions conditions);

    public void deleteLineByHeadId(Long organizationId,
                                  Long soheaderid);

    public ResponseEntity<String> deleteOrder(Long organizationId,
                                              Long soHeaderId);

    public Order addOrder(Long organizationId,Order order);
}
