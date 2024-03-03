package com.example.graduationproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.graduationproject.entity.DishInformation;
import com.example.graduationproject.entity.Order;
import com.example.graduationproject.entity.Orderinfo;

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
public interface OrderinfoMapper extends BaseMapper<Orderinfo> {
    //根据商家id来获取订单
    List<Map<String,Object>> getDishByOrderid(String[] dishidlist);
    //根据订单id获取菜品
    List<Map<String,Object>> getOrderMealsByOrderId(String orderid);

    List<Map<String,Object>> getOrderByBuId(String buid);

}
