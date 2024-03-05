package com.example.graduationproject.mapper;

import com.example.graduationproject.entity.DiningTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

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

//      <!--    &#45;&#45; 根据商家id获取商家餐桌类型信息-->
    public List<Map<String,Object>> getBusinessDining(String buid);

          void updateTableByTableId(DiningTable diningTable);


}
