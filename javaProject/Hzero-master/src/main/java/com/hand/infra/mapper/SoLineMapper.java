package com.hand.infra.mapper;

import com.hand.domain.entity.SoLine;
import io.choerodon.mybatis.common.BaseMapper;

import java.util.List;

/**
 * Mapper
 *
 * @author sh1101315853@163.com 2020-07-27 15:21:08
 */
public interface SoLineMapper extends BaseMapper<SoLine> {

    /**
     * 根据订单头id查询该订单下的所有行
     * @param soHeaderId 订单头id
     * @return 返回所有的订单行数据
     **/
    List<SoLine> selectById(Long soHeaderId);
}
