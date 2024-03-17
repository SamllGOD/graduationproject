package com.example.graduationproject.controller;

import com.example.graduationproject.common.vo.Result;
import com.example.graduationproject.entity.DishInformation;
import com.example.graduationproject.service.IDishInformationService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    @GetMapping("selectdishbypricebetween")
    public Result<?> getdishbypricebetween(@RequestParam("price1") String lowPrice,
                                           @RequestParam("price2") String highPrice){
       Map<String,Object>   data =  iDishInformationService.getdishbypricebetween(lowPrice,highPrice);
        if (data != null){
            return Result.success(data);
        }
        return Result.fail("未找到该价格区间的食品");
    }
    @GetMapping("selectDishByDishName")
    public Result<?> getDishByDishName(@RequestParam("dishname") String dishname){
        Map<String,Object>   data=  iDishInformationService.getDishByDishName(dishname);
        if (data != null){
            return Result.success(data);
        }
        return Result.fail("未找到该名称的食品");
    }


    @DeleteMapping("DeleteDishByDishIdAndDishBuId")
    public Result<?> DeleteDishByDishIdAndDishBuId(@RequestParam("dishid") String dishid,
                                                   @RequestParam("buid") String buid){
        iDishInformationService.DeleteDishByDishIdAndDishBuId(dishid,buid);
        return Result.success("更改成功");
    }
    @PostMapping("AddDishFromBuId")
    public Result<?> AddDishFromBuId(@RequestBody DishInformation dishInformation){
        iDishInformationService.AddDishFromBuId(dishInformation);
        return Result.success("增加成功");
    }
    @GetMapping("getDishByCreateTime")
    public Result<?> getDishByCreateTime(){
      Map<String,Object> data  =  iDishInformationService.getDishByCreateTime();
      return Result.success(data);
    }

    @GetMapping("getDishByMySelf")
    public Result<?> getDishByMySelf(@RequestParam("price") String price,
                                     @RequestParam("dishnumber") Integer dishnumber,
                                     @RequestParam("dishcategory") String dishcategory){

     Map<String,Object>  data = iDishInformationService.getDishByMySelf();
    return null;

    }

    //系统自助配菜
    @GetMapping("getDishByPriceCommend")
    public Result<?> getDishByPriceCommend(@RequestParam("totalprice") Double price, //总价
                                           @RequestParam("rulesdish")  Integer rulesDish,//优先满足
                                           @RequestParam("dishcategoryRouNumber") Integer dishcategoryRouNumber,//需要肉菜数量
                                           @RequestParam("dishcategoryshuNumber") Integer dishcategoryshuNumber,//需要蔬菜数量
                                           @RequestParam("dishcategorytangNumber") Integer dishcategorytangNumber,//需要汤品数量
                                           @RequestParam("dishcategoryzhuNumber") Integer dishcategoryzhuNumber//需要主食数量
                                                                                                                 ){

        Map<String,Object>  data = iDishInformationService.getDishByPriceCommend(price,
                                                                rulesDish,
                                                                dishcategoryRouNumber,
                                                                 dishcategoryshuNumber,
                                                                     dishcategorytangNumber,
                                                                        dishcategoryzhuNumber);
    if (data != null){
        return Result.success(data);
    }
return Result.fail("未获得数据");
    }
    //系统自助配菜
    @GetMapping("getMyselfPointDish")
    public Result<?> getMyselfPointDish(   @RequestParam("totalprice") Double price, //总价
                                           @RequestParam("bigdishnumber")  Integer bigdishnumber,//大菜
                                           @RequestParam("dishcategoryRouNumber") Integer dishcategoryRouNumber,//需要肉菜数量
                                           @RequestParam("dishcategoryshuNumber") Integer dishcategoryshuNumber,//需要蔬菜数量
                                           @RequestParam("dishcategorytangNumber") Integer dishcategorytangNumber,//需要汤品数量
                                           @RequestParam("dishcategoryzhuNumber") Integer dishcategoryzhuNumber//需要主食数量
    ){
        System.out.println("price:"+price);
        System.out.println("bigdishnumber:"+bigdishnumber);
        System.out.println("dishcategoryRouNumber:"+dishcategoryRouNumber);
        System.out.println("dishcategoryshuNumber:"+dishcategoryshuNumber);
        System.out.println("dishcategorytangNumber:"+dishcategorytangNumber);
        System.out.println("dishcategoryzhuNumber:"+dishcategoryzhuNumber);
        Map<String,Object>  data = iDishInformationService.getMyselfPointDish(price,
                bigdishnumber,
                dishcategoryRouNumber,
                dishcategoryshuNumber,
                dishcategorytangNumber,
                dishcategoryzhuNumber);
        if (data != null){
            return Result.success(data);
        }
        return Result.fail("未获得数据");
    }
















}
