package com.example.graduationproject.controller;

import com.example.graduationproject.common.vo.Result;
import com.example.graduationproject.service.IDishInformationService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/dishinformation")
public class DishInformationController {
    @Resource
    private IDishInformationService iDishInformationService;
    @GetMapping("dishsetredis")
    public Result<?> dishsetredis(@RequestParam("bid") String businessid){
        Map<String, Object> data = iDishInformationService.setredis(businessid);
        if (data != null){
            return Result.success(data);
        }
        return Result.fail("无数据");
    }
    @GetMapping("dishinfo")
    public Result<?> getdishinfo(@RequestParam("token") String token){
        Object data = iDishInformationService.dishinfo(token);
        if (data != null){
            return Result.success(data);
        }
        return Result.fail(2001,"为获取到消息");
    }
}
