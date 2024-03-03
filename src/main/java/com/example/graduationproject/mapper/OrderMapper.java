package com.example.graduationproject.mapper;

import com.example.graduationproject.entity.Order;
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
public interface OrderMapper extends BaseMapper<Order> {
    //根据商家id来获取到商家订单id，菜品总价格
     public List<Order> getOrderCenterIdByBusinessId(String buid);

}
