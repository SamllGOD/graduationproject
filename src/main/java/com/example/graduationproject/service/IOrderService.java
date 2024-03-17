package com.example.graduationproject.service;

import com.example.graduationproject.entity.Comments;
import com.example.graduationproject.entity.Order;
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
public interface IOrderService extends IService<Order> {

    Order selectByOrderNo(String orderNo);

    Integer addorder(Order order,String userid);

    Map<String, Object> getOrderByUserId(String userid);

    void deleteorderbyordercenterid(String ordercenterid);

    Map<String, Object> getOrderdishByOrdercenterid(String orderid);

    void insertCommentsByUserIDAndOrderId(String commentsContent,String commentsUserId,Integer commentsNumber,String commentsOrderid);

    Map<String,Object> selectCountCommentByOrderId(String orderid);

    void dishCommentByDishId( Integer dishpoint,String dishid,String orderid);


    Map<String, Object> selectOrdering(String userid, String ordering);

    Map<String, Object> selectOrderByDiningOptions(String userid, String diningoptions);

    Map<String, Object> selectOrderHaveDishName(String userid, String dishname);
}
