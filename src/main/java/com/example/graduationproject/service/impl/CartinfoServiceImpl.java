package com.example.graduationproject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.graduationproject.entity.Cart;
import com.example.graduationproject.entity.Cartinfo;
import com.example.graduationproject.mapper.CartMapper;
import com.example.graduationproject.mapper.CartinfoMapper;
import com.example.graduationproject.service.ICartService;
import com.example.graduationproject.service.ICartinfoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
@Service
public class CartinfoServiceImpl extends ServiceImpl<CartinfoMapper, Cartinfo> implements ICartinfoService {

    @Override
    public Map<String, Object> getUserCart(String userid) {
        List<Map<String, Object>> userCartMessage = this.baseMapper.getUserCart(userid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("cartmessage",userCartMessage);
        return map;
    }

    @Override
    public  Map<String, Object> getCartDish(String cartinfoid) {
        List<Map<String, Object>> cartDishInfoByCartInfoId = this.baseMapper.getCartDishInfoByCartInfoId(cartinfoid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("cartdishbyid",cartDishInfoByCartInfoId);
        return map;
    }
}
