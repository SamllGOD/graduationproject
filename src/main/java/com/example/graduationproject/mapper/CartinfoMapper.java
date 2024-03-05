package com.example.graduationproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.graduationproject.entity.Cart;
import com.example.graduationproject.entity.Cartinfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
public interface CartinfoMapper extends BaseMapper<Cartinfo> {
    public List<Map<String,Object>> getUserCart(String userid);

    public List<Map<String,Object>> getCartDishInfoByCartInfoId(String cartinfoid);
}
