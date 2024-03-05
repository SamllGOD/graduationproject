package com.example.graduationproject.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.graduationproject.entity.Cart;
import com.example.graduationproject.entity.Cartinfo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
public interface ICartinfoService extends IService<Cartinfo> {

    Map<String, Object> getUserCart(String userid);

    Map<String, Object> getCartDish(String cartinfoid);
}
