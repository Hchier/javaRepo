package com.hand.app.service.impl;

import com.hand.app.service.SoLineService;
import com.hand.domain.entity.SoLine;
import com.hand.infra.mapper.SoLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SoLineServiceImpl implements SoLineService {
    @Autowired
    private SoLineMapper soLineMapper;


    @Override
    public List<SoLine> selectById(Long soHeaderId) {
        return soLineMapper.selectById(soHeaderId);
    }
}
