package com.hand.app.service;

import com.hand.domain.entity.SoLine;

import java.util.List;


public interface SoLineService {

    /**
     * 根据订单头id查询该订单下的所有行
     * @param soHeaderId 订单头id
     * @return 返回所有的订单行数据
     **/
    List<SoLine> selectById(Long soHeaderId);
}
