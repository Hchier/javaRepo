package com.hand.infra.repository.impl;

import com.hand.infra.mapper.SoLineMapper;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import com.hand.domain.entity.SoLine;
import com.hand.domain.repository.SoLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SoLineRepositoryImpl extends BaseRepositoryImpl<SoLine> implements SoLineRepository {

    @Autowired
    SoLineMapper soLineMapper;
    @Override
    public List<SoLine> selectById(Long so_line_id) {
        return soLineMapper.selectById(so_line_id);
    }

    @Override
    public List<SoLine> selectAllInfo() {
        return soLineMapper.selectAllInfo();
    }

    @Override
    public void deleteById(Long so_line_id) {
        soLineMapper.deleteById(so_line_id);
    }

    @Override
    public void deleteBySoHeaderId(Long so_header_id) {
        soLineMapper.deleteBySoHeaderId(so_header_id);
    }

    @Override
    public List<SoLine> selectBySoHeaderId(Long so_header_id) {
        return soLineMapper.selectBySoHeaderId(so_header_id);
    }
}
