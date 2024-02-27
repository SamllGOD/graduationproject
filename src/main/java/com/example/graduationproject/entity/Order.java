package com.example.graduationproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xxay
 * @since 2024-02-27
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 逻辑删除
     */
    @TableId(value = "order_center_id", type = IdType.AUTO)
    private Integer orderCenterId;

    /**
     * 菜品id
     */
    private Integer dishId;

    /**
     * 购买数量
     */
    private Integer purchaseQuantity;

    /**
     * 菜品总价格
     */
    private BigDecimal totalPrice;

    /**
     * 餐厅id
     */
    private Integer diningTableId;

    /**
     * 支付状态
     */
    private String payStay;

    /**
     * 支付类型
     */
    private String payType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 智能推荐
     */
    private String recommend;

    /**
     * 就餐方式 堂食0 自提1 外送2
     */
    private Integer diningoptions;

    /**
     * 正在进行：0  已结束进入历史订单中：1
     */
    private Integer ordering;

    /**
     * 正常单：0 预约单：1 未支付：2
     */
    private Integer orderType;

    /**
     * 预约单id
     */
    private Integer orderMealId;

    /**
     * 逻辑删除  0未删除 1 已删除
     */
    private Integer orderDe;

    public Integer getOrderCenterId() {
        return orderCenterId;
    }

    public void setOrderCenterId(Integer orderCenterId) {
        this.orderCenterId = orderCenterId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(Integer diningTableId) {
        this.diningTableId = diningTableId;
    }

    public String getPayStay() {
        return payStay;
    }

    public void setPayStay(String payStay) {
        this.payStay = payStay;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public Integer getDiningoptions() {
        return diningoptions;
    }

    public void setDiningoptions(Integer diningoptions) {
        this.diningoptions = diningoptions;
    }

    public Integer getOrdering() {
        return ordering;
    }

    public void setOrdering(Integer ordering) {
        this.ordering = ordering;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderMealId() {
        return orderMealId;
    }

    public void setOrderMealId(Integer orderMealId) {
        this.orderMealId = orderMealId;
    }

    public Integer getOrderDe() {
        return orderDe;
    }

    public void setOrderDe(Integer orderDe) {
        this.orderDe = orderDe;
    }

    @Override
    public String toString() {
        return "Order{" +
            "orderCenterId = " + orderCenterId +
            ", dishId = " + dishId +
            ", purchaseQuantity = " + purchaseQuantity +
            ", totalPrice = " + totalPrice +
            ", diningTableId = " + diningTableId +
            ", payStay = " + payStay +
            ", payType = " + payType +
            ", createTime = " + createTime +
            ", updateTime = " + updateTime +
            ", recommend = " + recommend +
            ", diningoptions = " + diningoptions +
            ", ordering = " + ordering +
            ", orderType = " + orderType +
            ", orderMealId = " + orderMealId +
            ", orderDe = " + orderDe +
        "}";
    }
}
