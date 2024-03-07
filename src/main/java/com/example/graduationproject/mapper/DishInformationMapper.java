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

   List<DishInformation> getAllDishMessage();

   // 菜品味道
   List<DishInformation> SelectDishByDishType(String dtype);

   //菜品种类
   List<DishInformation> SelectDishByDishCategory(String dcategory);

   List<DishInformation> selectDishByDishAddressOrDishCareers(String useraddress,String usercareers);

   List<DishInformation> selectDishByPriceBetween(String lowPrice,String highPrice);

   List<DishInformation> selectDishByDishName(String dishName);

   void DeleteDishByDishIdAndDishBuId(String dishid,String buid);

   void AddDishFromBuId(DishInformation dishInformation);
}
