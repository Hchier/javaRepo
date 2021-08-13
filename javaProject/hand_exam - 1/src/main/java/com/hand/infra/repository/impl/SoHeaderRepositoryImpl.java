package com.hand.infra.repository.impl;

import com.hand.api.controller.dto.OrderReturnDTO;
import com.hand.domain.entity.OrderSummaryQuery;
import com.hand.infra.mapper.SoHeaderMapper;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import com.hand.domain.entity.SoHeader;
import com.hand.domain.repository.SoHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SoHeaderRepositoryImpl extends BaseRepositoryImpl<SoHeader> implements SoHeaderRepository {

    @Autowired
    SoHeaderMapper soHeaderMapper;

    @Override
    public List<OrderSummaryQuery> orderSummaryQuery(Long company_id, Long customer_id, String order_number, String order_status) {
        return soHeaderMapper.orderSummaryQuery(company_id, customer_id, order_number, order_status);
    }
    @Override
    public  List<SoHeader> selectAllInfo(){
        return soHeaderMapper.selectAllInfo();
    }

    @Override
    public void deleteById(Long so_header_id) {
        soHeaderMapper.deleteById(so_header_id);
    }


    @Override
    public OrderReturnDTO selectById(Long so_header_id) {
        return soHeaderMapper.selectById(so_header_id);
    }

//    @Override
//    public SoHeader selectById(Long so_header_id) {
//        return soHeaderMapper.selectById(so_header_id);
//    }

    @Override
    public void insertInfo(SoHeader soHeader) {
        soHeaderMapper.insertInfo(soHeader);
    }

    @Override
    public void updateStatus(Long so_header_id, String order_status) {
        soHeaderMapper.updateStatus(so_header_id,order_status);
    }

}
