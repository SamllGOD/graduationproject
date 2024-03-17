package com.example.graduationproject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.graduationproject.entity.DishInformation;
import com.example.graduationproject.entity.Order;
import com.example.graduationproject.entity.Orderinfo;
import com.example.graduationproject.mapper.DishInformationMapper;
import com.example.graduationproject.mapper.OrderMapper;
import com.example.graduationproject.mapper.OrderinfoMapper;
import com.example.graduationproject.service.IOrderinfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
@Service
public class OrderinfoServiceImpl extends ServiceImpl<OrderinfoMapper, Orderinfo> implements IOrderinfoService {
    @Resource
    DishInformationMapper dishInformationMapper;


    @Resource
    OrderinfoMapper orderinfoMapper;


    @Override
    public Map<String,Object> getOrderCenterIdByBusinessId(String businessId) {

        List<Map<String,Object>> orderByBuId = this.baseMapper.getOrderByBuId(businessId);
        HashMap<String , Object> map = new HashMap<>();
        map.put("ordermessage",orderByBuId);
        return map;


//        System.out.println( idlist.get(0).getOrderCenterId());
    }
    //在orderinfo表获取到菜品id
    @Override
    public Map<String, Object> getOrderDishByOrderId(String orderid) {
        List<Map<String, Object>> orderMealsByBuId = this.baseMapper.getOrderMealsByOrderId(orderid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("key",orderMealsByBuId);
        return map;
    }
    @Override
    public Map<String, Object> getDishByOrderId(String[] orderid) {
        List<Map<String, Object>> dishByOrderId = this.baseMapper.getDishByOrderid(orderid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("dishmessage",dishByOrderId);
        return map;
    }

    @Override
    public void uporderdishmeals(String dishid) {
        this.baseMapper.uporderdishmeals(dishid);
    }


}
