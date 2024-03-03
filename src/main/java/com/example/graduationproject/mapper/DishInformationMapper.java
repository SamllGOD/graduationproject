package com.example.graduationproject.mapper;

import com.example.graduationproject.entity.DishInformation;
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
public interface DishInformationMapper extends BaseMapper<DishInformation> {
   List<DishInformation> getAllByBusinessId(String buid);

   DishInformation getDishmessageByDishId(String dishid);

   List<DishInformation> getDishByDishId(String orderbuid);
}
