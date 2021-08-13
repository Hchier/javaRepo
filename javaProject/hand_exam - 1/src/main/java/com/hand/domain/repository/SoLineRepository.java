package com.hand.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hand.domain.entity.SoLine;

import java.util.List;


public interface SoLineRepository extends BaseRepository<SoLine> {
    List<SoLine> selectById(Long so_line_id);

    public List<SoLine> selectAllInfo();

    public void deleteById(Long so_line_id);

    public void deleteBySoHeaderId(Long so_header_id);

    public List<SoLine> selectBySoHeaderId(Long so_header_id);
}
