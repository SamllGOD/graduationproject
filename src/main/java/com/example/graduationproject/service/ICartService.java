package com.example.graduationproject.service;

import com.example.graduationproject.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
public interface ICartService extends IService<Cart> {

    void dishjoincart(String userid, String dishinfoid, Integer cartdishnumber, Double carttotalprice);

    void upCartInfoDishNumber(  String cartdishnumber,String cartinfoid,Double carttotalprice);

    void deleteCartDishByCartInfoId(String cartinfoid);
}
