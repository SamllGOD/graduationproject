package com.example.graduationproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@TableName(value ="cartinfo", autoResultMap = true)
public class Cartinfo {
    private static final long serialVersionUID = 1L;

    /**
     * 购物车id
     */
    @TableId(value = "cartinfoid", type = IdType.AUTO)
    private Integer cartinfoid;

    private Integer cartiid;

    private Integer dishinfoid;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;

    private Integer cartpay;

    private Integer cartdishnumber;

    private BigDecimal carttotalprice;

    public Integer getCartinfoid() {
        return cartinfoid;
    }

    public void setCartinfoid(Integer cartinfoid) {
        this.cartinfoid = cartinfoid;
    }

    public Integer getCartiid() {
        return cartiid;
    }

    public void setCartiid(Integer cartiid) {
        this.cartiid = cartiid;
    }

    public Integer getDishinfoid() {
        return dishinfoid;
    }

    public void setDishinfoid(Integer dishinfoid) {
        this.dishinfoid = dishinfoid;
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

    public Integer getCartpay() {
        return cartpay;
    }

    public void setCartpay(Integer cartpay) {
        this.cartpay = cartpay;
    }

    public Integer getCartdishnumber() {
        return cartdishnumber;
    }

    public void setCartdishnumber(Integer cartdishnumber) {
        this.cartdishnumber = cartdishnumber;
    }

    public BigDecimal getCarttotalprice() {
        return carttotalprice;
    }

    public void setCarttotalprice(BigDecimal carttotalprice) {
        this.carttotalprice = carttotalprice;
    }

    @Override
    public String toString() {
        return "Cartinfo{" +
                "cartinfoid=" + cartinfoid +
                ", cartiid=" + cartiid +
                ", dishinfoid=" + dishinfoid +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", cartpay=" + cartpay +
                ", cartdishnumber=" + cartdishnumber +
                ", carttotalprice=" + carttotalprice +
                '}';
    }
}
