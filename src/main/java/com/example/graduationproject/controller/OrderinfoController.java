package com.example.graduationproject.controller;

import com.example.graduationproject.common.vo.Result;
import com.example.graduationproject.service.IOrderinfoService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
@RestController
@RequestMapping("/orderinfo")
public class OrderinfoController {

    @Resource
    private IOrderinfoService iOrderinfoService;
    @Resource
    private RedisTemplate redisTemplate;
    @GetMapping("getorder")
    public Result<?> getbusinessmenorder(@RequestParam("buid") String businessId){
           //获取orderCenterId根据商家id
        Map<String, Object> data = iOrderinfoService.getOrderCenterIdByBusinessId(businessId);
       if (data != null){
           return Result.success(data);
       }
       return Result.fail("未找到数据");
    }

    @GetMapping("getorderinfo")
    public Result<?> getOrderDishByOrderId(@RequestParam("orderid") String orderid){
        //获取orderCenterId根据商家id
        Map<String, Object> data = iOrderinfoService.getOrderDishByOrderId(orderid);
        if (data != null){
            return Result.success(data);
        }
        return Result.fail("未找到数据");
    }

    @GetMapping("getDishByOrderId")
    public Result<?> getDishByOrderId(@RequestParam("orderId") String[] orderid){
        //获取orderCenterId根据商家id
        Map<String, Object> data = iOrderinfoService.getDishByOrderId(orderid);
        if (data != null){
            return Result.success(data);
        }
        return Result.fail("未找到数据");
    }

}
