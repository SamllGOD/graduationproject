package com.example.graduationproject.controller;

import com.example.graduationproject.common.vo.Result;
import com.example.graduationproject.entity.DiningTable;
import com.example.graduationproject.service.IDiningTableService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

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
    private RedisTemplate redisTemplate;
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
        return Result.fail(2001,"未找到数据,请检查key");
    }

    //根据餐厅id获取
    @GetMapping("diningmessageforid")
    public  Result<?> getmessageforid(@RequestParam("tableid") String tableid){
        Map<String, Object> data = diningTableService.getmessagefordinid(tableid);
        if (data != null){
            return Result.success(data);
        }
        return Result.fail("未找到数据");
    }

    //根据商家id获取指定字段
    @GetMapping("getBusinessDining")
    public Result<?> getBusinessDining(@RequestParam("businessid") String buid){
        Map<String, Object> data = diningTableService.getBusinessDining(buid);
        if (data != null){
            return Result.success(data);
        }
        return Result.fail("未找到数据");
    }


    @PatchMapping("upeTableByDiningTableId")
    public Result<?> upeTableByDiningTableId(@RequestBody DiningTable diningTable){
        System.out.println(diningTable);
        diningTableService.upeTableByDiningTableId(diningTable);
        return Result.success("修改成功");
    }


}
