package com.example.graduationproject.service.impl;

import com.example.graduationproject.entity.Cart;
import com.example.graduationproject.mapper.CartMapper;
import com.example.graduationproject.service.ICartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

    @Override
    public void dishjoincart(String userid, String dishinfoid, Integer cartdishnumber, Double carttotalprice) {
        String cartid = this.baseMapper.selectCartIdByUserId(userid);
        System.out.println(cartid);
        this.baseMapper.dishJoinCartByUserId(cartid,dishinfoid,cartdishnumber,carttotalprice);
    }

    @Override
    public void upCartInfoDishNumber(String  cartinfoid,String cartdishnumber,Double carttotalprice) {
        this.baseMapper.upCartInfoDishNumber(cartdishnumber,cartinfoid,carttotalprice);
    }

    @Override
    public void deleteCartDishByCartInfoId(String cartinfoid) {
        this.baseMapper.deleteCartDishByCartInfoId(cartinfoid);
    }
}
