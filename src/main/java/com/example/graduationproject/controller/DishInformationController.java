package com.example.graduationproject.controller;

import com.example.graduationproject.common.vo.Result;
import com.example.graduationproject.entity.DishInformation;
import com.example.graduationproject.service.IDishInformationService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

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
    @GetMapping("getdishinfoindishid")
    public  Result<?> getdishmessagefordishid(@RequestParam("dishid") String dishid){
     Map<String,Object> data =  iDishInformationService.getdishmessagefordishid(dishid);
     if (data != null){
         return Result.success(data);
     }
     return  Result.fail(2001,"为获取到消息");
    }
    @PostMapping("adddish")
    public Result<?> adddish(@RequestBody DishInformation dishInformation){
        iDishInformationService.save(dishInformation);
        return Result.success("添加成功");
    }

    @GetMapping("getalldishmessage")
    public Result<?> getalldishmessage(){
        Map<String, Object> data = iDishInformationService.getalldishmessage();
        if (data != null){
            return Result.success(data);
        }
        return Result.fail("未找到数据");
    }

    @GetMapping("selectdishbydishtype")
    public  Result<?> getdishbydishtype(@RequestParam("dishtype") String dishtype){
        Map<String, Object> data =  iDishInformationService.getdishbydishtype(dishtype);
     if (data != null){
         return Result.success(data);
     }
     return Result.fail("未找到该口味的食品");
    }

    @GetMapping("selectdishbydishcategory")
    public  Result<?> getDishbydishcategory(@RequestParam("category") String category){
        Map<String, Object> data =  iDishInformationService.getDishbydishcategory(category);
        if (data != null){
            return Result.success(data);
        }
        return Result.fail("未找到该种类的食品");
    }

    @GetMapping("getdishbydishaddressordishcareers")
    public  Result<?> getdishbydishaddressordishcareers(@RequestParam("address") String address,
                                                        @RequestParam("careers") String careers
                                                       ){
              Map<String,Object> data = iDishInformationService.getdishbydishaddressordishcareers(address,careers);
        if (data != null){
            return Result.success(data);
        }
        return Result.fail("未找到该推荐食品");
    }


}
