package com.example.graduationproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;

@TableName(value = "orderinfo",autoResultMap = true)
public class Orderinfo {
    private static final long serialVersionUID = 1L;
    @TableId(value = "createorder_id", type = IdType.AUTO)
    private Integer createorderId;

    private Integer orderId;

    private Integer dishInfoid;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createtime;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updatetime;

    private String orderMeals;

    private Integer orderDishNumber;

    private Integer orderdishcomment;



    public Integer getCreateorderId() {
        return createorderId;
    }

    public void setCreateorderId(Integer createorderId) {
        this.createorderId = createorderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getDishInfoid() {
        return dishInfoid;
    }

    public void setDishInfoid(Integer dishInfoid) {
        this.dishInfoid = dishInfoid;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public LocalDateTime getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(LocalDateTime updatetime) {
        this.updatetime = updatetime;
    }


    public String getOrderMeals() {
        return orderMeals;
    }

    public void setOrderMeals(String orderMeals) {
        this.orderMeals = orderMeals;
    }

    public Integer getOrderDishNumber() {
        return orderDishNumber;
    }

    public void setOrderDishNumber(Integer orderDishNumber) {
        this.orderDishNumber = orderDishNumber;
    }


    public Integer getOrderdishcomment() {
        return orderdishcomment;
    }

    public void setOrderdishcomment(Integer orderdishcomment) {
        this.orderdishcomment = orderdishcomment;
    }

    @Override
    public String toString() {
        return "Orderinfo{" +
                "createorderId=" + createorderId +
                ", orderId=" + orderId +
                ", dishInfoid=" + dishInfoid +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", orderMeals='" + orderMeals + '\'' +
                ", orderDishNumber=" + orderDishNumber +
                ", orderdishcomment=" + orderdishcomment +
                '}';
    }
}
