package com.example.graduationproject.service.impl;

import com.example.graduationproject.entity.*;
import com.example.graduationproject.mapper.OrderMapper;
import com.example.graduationproject.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {


    @Override
    public Order selectByOrderNo(String orderNo) {
        Order order = this.baseMapper.selectByOrderId(orderNo);
        return order;
    }

    @Override
    public Integer addorder(Order order,String userid) {

        System.out.println(order.getOrderDinid() + order.getDiningoptions());
        if (order.getDiningoptions().equals("堂食")){
            this.baseMapper.insertOrder(order);
        }else if (order.getDiningoptions().equals("自提")){
            this.baseMapper.insertOrderByMeal(order);
        }
//        获取自增id
        Integer orderid = order.getOrderCenterId();
//        根据用户id获取用户购物车id
        Integer cartid = this.baseMapper.selectCartIdInUserId(userid);
//        获取用户购物车id 在cartinfo表中进行查找菜品id
        List<Cartinfo> integers = this.baseMapper.selectDishIdInCartId(cartid);
//        获取用户购物车id 在cartinfo表中进行查找菜品数量
        System.out.println(integers);
//        将菜品id和订单id插入至orderinfo表中 还有数量
        this.baseMapper.insertCartInfo(orderid,integers);
        return orderid;
    }

    @Override
    public Map<String, Object> getOrderByUserId(String userid) {
        List<Order> orders = this.baseMapper.selectOrderByUserId(userid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("ordermessage",orders);
        return map;
    }

    @Override
    public void deleteorderbyordercenterid(String ordercenterid) {
        this.baseMapper.deleteorderbyordercenterid(ordercenterid);
    }

    @Override
    public Map<String, Object> getOrderdishByOrdercenterid(String orderid) {
        List<Orderinfo> getorderinfo = this.baseMapper.getorderinfo(orderid);
        List<Integer> dishidlist = new ArrayList<>();
        for(Orderinfo orderinfo : getorderinfo){
            Integer infoid = orderinfo.getDishInfoid();
            dishidlist.add(infoid);
        }
        //获取菜品数据
        List<DishInformation> getorderdish = this.baseMapper.getorderdish(dishidlist,orderid);
        //获取订单中菜品的评分数据
        HashMap<String, Object> map = new HashMap<>();
        map.put("orderdishinfo",getorderdish);
        return map;
    }

    @Override
    public void insertCommentsByUserIDAndOrderId(String commentsContent,String commentsUserId,Integer commentsNumber,String commentsOrderid) {
        this.baseMapper.insertCommentsByUserIDAndOrderId(commentsContent,commentsUserId,commentsNumber,commentsOrderid);
    }

    @Override
    public Map<String,Object> selectCountCommentByOrderId(String orderid) {
        Integer i = this.baseMapper.selectCountCommentByOrderId(orderid);
        if (i != 0){
            List<Map<String, Object>> maps = this.baseMapper.selectCommentByOrderId(orderid);
            System.out.println(maps.get(0));
            HashMap<String, Object> map = new HashMap<>();
            map.put("commentsmessage",maps.get(0));
            return map;
        }else {
            return null;
        }
    }

    @Override
    public void dishCommentByDishId(Integer dishpoint, String dishid  ,String orderid) {
        this.baseMapper.dishCommentByDishId(dishpoint,dishid);
        this.baseMapper.dishCommentByOrderId(dishpoint,orderid,dishid);
    }

    @Override
    public Map<String, Object> selectOrdering(String userid, String ordering) {
        List<Order> orders = this.baseMapper.selectOrdering(userid, ordering);
        HashMap<String, Object> map = new HashMap<>();
        map.put("ordersInOrdering",orders);
        return map;
    }

    @Override
    public Map<String, Object> selectOrderByDiningOptions(String userid, String diningoptions) {
        List<Order> orders = this.baseMapper.selectOrderByDiningOptions(userid, diningoptions);
        HashMap<String, Object> map = new HashMap<>();
        map.put("ordersInDiningOptions",orders);
        return map;
    }

    @Override
    public Map<String, Object> selectOrderHaveDishName(String userid, String dishname) {
        List<Order> orders = this.baseMapper.selectOrderHaveDishName(userid, dishname);
        HashMap<String, Object> map = new HashMap<>();
        map.put("ordershavedishname",orders);
        return map;
    }

    public void  upOrderType(String orderid){
        this.baseMapper.UpOrderType(orderid);
    }

    public void  upOrderPayTime(String orderpaytime, String orderid){
        this.baseMapper.UpOrderPayTime(orderpaytime,orderid);
    }


    public void  deCartInfoDish( String orderid){
        this.baseMapper.DeCartInfoDish(orderid);
    }
    public void  upTableInfo( String orderid){
        this.baseMapper.UpTableInfo(orderid);
    }

    @Override
    public Map<String, Object> getUserComment() {
        HashMap<String, Object> map = new HashMap<>();
        List<Map<String,Object>> userComment = this.baseMapper.getUserComment();
        System.out.println(userComment);
        List<String> dishNameByOrderId = this.baseMapper.getDishNameByOrderId("178");
        System.out.println(dishNameByOrderId);
        map.put("usercomment",userComment);
        return map;
    }

    @Override
    public Map<String, Object> getDishName(String userid, String commentsOrderid, String commentsId) {
        HashMap<String, Object> map = new HashMap<>();
        //菜品名称
        List<String> dishNameByOrderId = this.baseMapper.getDishNameByOrderId(commentsOrderid);
        map.put("dishname",dishNameByOrderId);
        System.out.println(dishNameByOrderId);
        //根据评价id获取到评价信息以及商家追评信息
        List<Map<String, Object>> commentById = this.baseMapper.getCommentById(commentsId);
        map.put("commentsInfo",commentById);
        System.out.println(commentById);
        //
        return map;
    }

    @Override
    public void addbusinessCommentsByID(String commentsid,String buCommentsInfo) {
        this.baseMapper.AddBusinessCommentsByID(commentsid,buCommentsInfo);
    }

    @Override
    public void getOrderDishNumberByOrderId(String orderid) {
        List<Orderinfo> orderDishNumberByOrderId = this.baseMapper.getOrderDishNumberByOrderId(orderid);
        this.baseMapper.upDishSoldByDishInfoId(orderDishNumberByOrderId);
    }


}
