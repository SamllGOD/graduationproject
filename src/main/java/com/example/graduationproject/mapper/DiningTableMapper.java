package com.example.graduationproject.mapper;

import com.example.graduationproject.entity.DiningTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
public interface DiningTableMapper extends BaseMapper<DiningTable> {
    public List<DiningTable> getAllByBusinessId(String buid);


}
