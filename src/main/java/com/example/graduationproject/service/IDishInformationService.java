package com.example.graduationproject.service;

import com.example.graduationproject.common.vo.Result;
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


}
