package com.example.graduationproject.controller;

import com.example.graduationproject.common.vo.Result;
import com.example.graduationproject.entity.Order;
import com.example.graduationproject.service.IOrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
   private IOrderService iOrderService;
    //新增订单接口
    @PostMapping("addOrder")
    public Result<?> addOrder(@RequestBody Order order){
        Integer orderid = iOrderService.addorder(order);
        //获取订单id
        return Result.success(orderid);
    }
}
