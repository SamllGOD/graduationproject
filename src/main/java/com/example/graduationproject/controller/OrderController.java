package com.example.graduationproject.controller;

import com.example.graduationproject.common.vo.Result;

import com.example.graduationproject.entity.Order;
import com.example.graduationproject.service.IOrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


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
@RequestMapping("/order")
public class OrderController {
    @Resource
   private IOrderService iOrderService;
    //新增订单接口
    @PostMapping("addOrder")
    public Result<?> addOrder(@RequestBody Order order,
                              @RequestParam String userid){
        Integer orderid = iOrderService.addorder(order,userid);
        //获取订单id
        return Result.success(orderid);
    }
    @GetMapping("getOrderByUserId")
    public Result<?> getOrderByUserId(@RequestParam("userid") String userid){
         Map<String,Object> data =  iOrderService.getOrderByUserId(userid);
         return Result.success(data);
    }
    @PatchMapping("deleteorderbyordercenterid")
    public Result<?> deleteorderbyordercenterid(@RequestParam("ordercenterid") String ordercenterid){
        iOrderService.deleteorderbyordercenterid(ordercenterid);
        return Result.success("删除成功");
    }
    @GetMapping("getOrderdishByOrdercenterid")
    public  Result<?> getOrderdishByOrdercenterid(@RequestParam("orderid") String orderid){
            Map<String,Object>  data =  iOrderService.getOrderdishByOrdercenterid(orderid);
        return Result.success(data);
    }
    @PostMapping("insertCommentsByUserIDAndOrderId")
    public Result<?> insertCommentsByUserIDAndOrderId(@RequestParam("commentsContent") String commentsContent,
                                                      @RequestParam("commentsUserId") String commentsUserId,
                                                      @RequestParam("commentsNumber") Integer commentsNumber,
                                                      @RequestParam("commentsOrderid") String commentsOrderid){
        iOrderService.insertCommentsByUserIDAndOrderId(commentsContent,commentsUserId,commentsNumber,commentsOrderid);
        return Result.success("评价成功");
    }
    @GetMapping("selectCountCommentByOrderId")
    public Result<?> selectCountCommentByOrderId(@RequestParam("orderid") String orderid){
        Map<String,Object> data = iOrderService.selectCountCommentByOrderId(orderid);
        if (data != null){
            return Result.success(data,"已存在评价");
        }else {
            return Result.success("未找到评价");
        }

    }
    @PatchMapping("dishCommentByDishId")
    public Result<?> dishCommentByDishId(@RequestParam("dishid") String dishid,
                                         @RequestParam("dishpoint") Integer dishpoint,
                                         @RequestParam("orderid") String orderid){
        iOrderService.dishCommentByDishId(dishpoint,dishid,orderid);
        return Result.success("评价成功");
    }

    @GetMapping("selectOrdering")
    public Result<?> selectOrdering(@RequestParam("userid") String userid,
                                    @RequestParam("ordering") String ordering){
                     Map<String,Object>  data = iOrderService.selectOrdering(userid,ordering);
                     if (data!=null){
                         return Result.success(data);
                     }return Result.fail("无数据");
    }

    @GetMapping("selectOrderByDiningOptions")
    public Result<?> selectOrderByDiningOptions(@RequestParam("userid") String userid,
                                    @RequestParam("diningoptions") String diningoptions){
        Map<String,Object>  data = iOrderService.selectOrderByDiningOptions(userid,diningoptions);
        if (data!=null){
            return Result.success(data);
        }return Result.fail("无数据");
    }

    @GetMapping("selectOrderHaveDishName")
    public Result<?> selectOrderHaveDishName(@RequestParam("userid") String userid,
                                                @RequestParam("dishname") String dishname){
        Map<String,Object>  data = iOrderService.selectOrderHaveDishName(userid,dishname);
        if (data!=null){
            return Result.success(data);
        }return Result.fail("无数据");
    }




























}
