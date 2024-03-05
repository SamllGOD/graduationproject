package com.example.graduationproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.graduationproject.entity.Order;
import com.example.graduationproject.entity.TableInfo;

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
public interface TablerInfoMapper extends BaseMapper<TableInfo> {
      public   List<Map<String ,Object>> getTableIdByDiningId(String diningid);
}
