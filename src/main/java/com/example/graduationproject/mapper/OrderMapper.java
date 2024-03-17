package com.example.graduationproject.mapper;

import com.example.graduationproject.entity.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Setter;
import org.apache.ibatis.annotations.Select;

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
public interface OrderMapper extends BaseMapper<Order> {
    //根据商家id来获取到商家订单id，菜品总价格
     public List<Order> getOrderCenterIdByBusinessId(String buid);

     //测试支付宝沙箱


  public   Order selectByOrderId(String orderid);
   public void insertOrder(Order order);


   List<Order> selectOrderByUserId(String userid);

   void  deleteorderbyordercenterid(String orderid);

   List<Orderinfo> getorderinfo(String orderid);

   List<DishInformation> getorderdish(List<Integer> dishidlist,String orderid);

   void insertCommentsByUserIDAndOrderId(String commentsContent,
                                         String commentsUserId,
                                         Integer commentsNumber,
                                         String commentsOrderid);
    Integer selectCountCommentByOrderId(String orderid);

    List<Map<String,Object>> selectCommentByOrderId(String orderid);

    void dishCommentByThreeDay(String dishid);

    void dishCommentByDishId(Integer dishpoint,String dishid);

    void dishCommentByOrderId(Integer dishpoint,String orderid,String dishid);

    List<Order> selectOrdering(String userid,String ordering);

    List<Order> selectOrderByDiningOptions(String userid,String diningoptions);

    List<Order> selectOrderHaveDishName(String userid,String dishname);

    Integer selectCartIdInUserId(String userid);

    List<Cartinfo> selectDishIdInCartId(Integer cartid);

     List<Integer> selectCartDishNumberInCartId(Integer cartid);

     void insertCartInfo(Integer orderid,List<Cartinfo> cartinfolist);
}
