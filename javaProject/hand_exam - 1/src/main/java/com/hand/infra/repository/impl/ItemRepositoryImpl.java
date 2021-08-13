package com.hand.infra.repository.impl;

import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import com.hand.domain.entity.Item;
import com.hand.domain.repository.ItemRepository;
import org.springframework.stereotype.Component;

@Component
public class ItemRepositoryImpl extends BaseRepositoryImpl<Item> implements ItemRepository {

  
}
