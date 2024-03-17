package com.example.graduationproject.mapper;

import com.example.graduationproject.entity.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.math.BigDecimal;
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
public interface CartMapper extends BaseMapper<Cart> {

 String selectCartIdByUserId(String userid);

 void dishJoinCartByUserId(String cartid, String dishinfoid, Integer cartdishnumber, Double carttotalprice);

 void upCartInfoDishNumber( String cartdishnumber,String cartinfoid);

 void deleteCartDishByCartInfoId(String cartinfoid);

}
