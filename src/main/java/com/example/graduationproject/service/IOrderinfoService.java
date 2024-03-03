package com.example.graduationproject.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.graduationproject.entity.Orderinfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
public interface IOrderinfoService extends IService<Orderinfo> {


    Map<String,Object> getOrderCenterIdByBusinessId(String businessId);

    Map<String, Object> getOrderDishByOrderId(String orderid);

    Map<String, Object> getDishByOrderId(String[] orderid);
}
