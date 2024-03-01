package com.example.graduationproject.controller;

import com.example.graduationproject.common.vo.Result;
import com.example.graduationproject.service.IDiningTableService;
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
@RequestMapping("/diningTable")
public class DiningTableController {
    @Resource
   private IDiningTableService diningTableService;
    @GetMapping("dinsetredis")
    public Result<?> dinsetredis(@RequestParam("bid") String busingssid) {
        Object data = diningTableService.setredis(busingssid);
        if (data != null) {
            //diningtoken返回给前端
            return Result.success(data);
        }
        return null;
    }
    //获取餐桌信息表
    @GetMapping("dininginfo")
    public Result<?> dininginfo(@RequestParam("token") String token){
        Object data = diningTableService.getdininginfo(token);
        if (data != null){
            return Result.success(data);
        }
        return Result.fail(2001,"为获取到消息");
    }


}
