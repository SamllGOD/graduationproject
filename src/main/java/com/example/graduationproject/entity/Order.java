package com.example.graduationproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@TableName(value = "order",autoResultMap = true)
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "order_center_id", type = IdType.AUTO)
    private Integer orderCenterId;

    private Integer purchaseQuantity;
    private BigDecimal totalPrice;
    private String payStay;

    private String payType;



    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;

    private  String recommend;

    private  Integer orderBuid;

    private  Integer orderUid;

    private String diningoptions;

    private Integer ordering;

    private Integer ordertype;

    private Integer orderDe;

    private  Integer orderDinid;
    
    private Integer orderNumber;




    private String orderPayType;


    public Integer getOrderCenterId() {
        return orderCenterId;
    }

    public void setOrderCenterId(Integer orderCenterId) {
        this.orderCenterId = orderCenterId;
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


    public Integer getOrderBuid() {
        return orderBuid;
    }

    public void setOrderBuid(Integer orderBuid) {
        this.orderBuid = orderBuid;
    }

    public Integer getOrderUid() {
        return orderUid;
    }

    public void setOrderUid(Integer orderUid) {
        this.orderUid = orderUid;
    }

    public String getDiningoptions() {
        return diningoptions;
    }

    public void setDiningoptions(String diningoptions) {
        this.diningoptions = diningoptions;
    }

    public Integer getOrdering() {
        return ordering;
    }

    public void setOrdering(Integer ordering) {
        this.ordering = ordering;
    }

    public Integer getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
    }

    public Integer getOrderDe() {
        return orderDe;
    }

    public void setOrderDe(Integer orderDe) {
        this.orderDe = orderDe;
    }

    public Integer getOrderDinid() {
        return orderDinid;
    }

    public void setOrderDinid(Integer orderDinid) {
        this.orderDinid = orderDinid;
    }


    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderPayType() {
        return orderPayType;
    }

    public void setOrderPayType(String orderPayType) {
        this.orderPayType = orderPayType;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderCenterId=" + orderCenterId +
                ", purchaseQuantity=" + purchaseQuantity +
                ", totalPrice=" + totalPrice +
                ", payStay='" + payStay + '\'' +
                ", payType='" + payType + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", recommend='" + recommend + '\'' +
                ", orderBuid=" + orderBuid +
                ", orderUid=" + orderUid +
                ", diningoptions='" + diningoptions + '\'' +
                ", ordering=" + ordering +
                ", ordertype=" + ordertype +
                ", orderDe=" + orderDe +
                ", orderDinid=" + orderDinid +
                ", orderNumber=" + orderNumber +
                ", orderPayType='" + orderPayType + '\'' +
                '}';
    }
}
