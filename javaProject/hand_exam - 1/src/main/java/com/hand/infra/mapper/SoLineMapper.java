package com.hand.infra.mapper;

import com.hand.domain.entity.SoLine;
import io.choerodon.mybatis.common.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoLineMapper extends BaseMapper<SoLine> {

    /**
     * 根据订单头id查询该订单下的所有行
     * @param soHeaderId 订单头id
     * @return 返回所有的订单行数据
     **/
    List<SoLine> selectById(Long so_line_id);

    public  List<SoLine> selectAllInfo();

    public void deleteById(Long so_line_id);

    public void deleteBySoHeaderId(Long so_header_id);

    public List<SoLine> selectBySoHeaderId(Long so_header_id);
}
