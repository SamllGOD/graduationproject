package com.example.graduationproject.controller;

import com.example.graduationproject.common.vo.Result;
import com.example.graduationproject.service.ICartinfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/cartinfo")
public class CartinfoController {
    @Resource
    private ICartinfoService iCartinfoService;
    @GetMapping("getusercart")
    public Result<?> getUserCart(@RequestParam("userId") String userid){
    Map<String,Object> data = iCartinfoService.getUserCart(userid);
        if (data != null){
            return Result.success(data);
        }
        return Result.fail("无数据");
    }

    @GetMapping("getCartDish")
    public Result<?> getCartDish(@RequestParam("cartinfoid") String cartinfoid){
        Map<String,Object> data = iCartinfoService.getCartDish(cartinfoid);
        if (data != null){
            return Result.success(data);
        }
        return Result.fail("无数据");
    }




}
