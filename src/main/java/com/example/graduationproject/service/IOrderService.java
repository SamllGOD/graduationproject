package com.example.graduationproject.service;

import com.example.graduationproject.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
public interface IOrderService extends IService<Order> {

    Order selectByOrderNo(String orderNo);

    Integer addorder(Order order);
}
