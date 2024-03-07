package com.example.graduationproject.service;

import com.example.graduationproject.entity.DishInformation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
public interface IDishInformationService extends IService<DishInformation> {


    Map<String ,Object> setredis(String businessid);

    Object dishinfo(String token);

    Map<String, Object> getdishmessagefordishid(String dishid);


    Map<String, Object> getalldishmessage();

    Map<String, Object> getdishbydishtype(String dishtype);

    Map<String, Object> getDishbydishcategory(String category);

    Map<String, Object> getdishbydishaddressordishcareers(String address, String careers);

    Map<String, Object> getdishbypricebetween(String lowPrice, String highPrice);

    Map<String, Object> getDishByDishName(String dishname);

    void DeleteDishByDishIdAndDishBuId(String dishid, String buid);

    void AddDishFromBuId(DishInformation dishInformation);
}
