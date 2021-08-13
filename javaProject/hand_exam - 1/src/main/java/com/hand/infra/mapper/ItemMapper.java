package com.hand.infra.mapper;

import com.hand.domain.entity.Item;
import io.choerodon.mybatis.common.BaseMapper;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemMapper extends BaseMapper<Item> {

}
