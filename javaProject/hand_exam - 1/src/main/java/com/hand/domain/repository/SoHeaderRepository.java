package com.hand.domain.repository;

import com.hand.api.controller.dto.OrderReturnDTO;
import com.hand.domain.entity.OrderSummaryQuery;
import org.hzero.mybatis.base.BaseRepository;
import com.hand.domain.entity.SoHeader;

import java.util.List;


public interface SoHeaderRepository extends BaseRepository<SoHeader> {
    public List<OrderSummaryQuery> orderSummaryQuery(Long company_id, Long customer_id, String order_number, String order_status);

    public  List<SoHeader> selectAllInfo();

    public void deleteById(Long so_header_id);

   // public SoHeader selectById(Long so_header_id);

    public OrderReturnDTO selectById(Long so_header_id);

    public void insertInfo(SoHeader soHeader);

    public void updateStatus(Long so_header_id,String order_status);
}
