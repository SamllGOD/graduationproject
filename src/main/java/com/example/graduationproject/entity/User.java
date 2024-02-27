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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "u_id", type = IdType.AUTO)
    private Integer uId;

    /**
     * 用户密码
     */
    private String uPwd;

    /**
     * 用户名
     */
    private String uName;

    /**
     * 用户年龄
     */
    private Integer uAge;

    /**
     * 用户地址
     */
    private String uAddress;

    /**
     * 用户口味 清淡 中等 重口
     */
    private String uFlavours;

    /**
     * 用户喜好：偏甜 偏咸 偏辣 偏酸
     */
    private String uPreferences;

    /**
     * 用户职业
     */
    private String uCareers;

    /**
     * 用户逻辑删除默认0未删除
     */
    private Integer uDelete;

    /**
     * 用户创建时间
     */
    private LocalDateTime uCreatetime;

    /**
     * 用户订单id
     */
    private Integer uHistoriesOrderId;

    /**
     * 用户购物车id
     */
    private Integer uCarsId;

    /**
     * 用户智能推荐
     */
    private String uRecommend;

    /**
     * 是否是商家 是： 1 不是 0
     */
    private Integer whetherBusinessmen;

    /**
     * 商家id
     */
    private Integer businessmenId;

    /**
     * 用户更新时间
     */
    private LocalDateTime uUpdateTime;

    /**
     * 用户预约id
     */
    private Integer uMealReservationId;

    /**
     * 用户余额
     */
    private BigDecimal uBalance;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Integer getuAge() {
        return uAge;
    }

    public void setuAge(Integer uAge) {
        this.uAge = uAge;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getuFlavours() {
        return uFlavours;
    }

    public void setuFlavours(String uFlavours) {
        this.uFlavours = uFlavours;
    }

    public String getuPreferences() {
        return uPreferences;
    }

    public void setuPreferences(String uPreferences) {
        this.uPreferences = uPreferences;
    }

    public String getuCareers() {
        return uCareers;
    }

    public void setuCareers(String uCareers) {
        this.uCareers = uCareers;
    }

    public Integer getuDelete() {
        return uDelete;
    }

    public void setuDelete(Integer uDelete) {
        this.uDelete = uDelete;
    }

    public LocalDateTime getuCreatetime() {
        return uCreatetime;
    }

    public void setuCreatetime(LocalDateTime uCreatetime) {
        this.uCreatetime = uCreatetime;
    }

    public Integer getuHistoriesOrderId() {
        return uHistoriesOrderId;
    }

    public void setuHistoriesOrderId(Integer uHistoriesOrderId) {
        this.uHistoriesOrderId = uHistoriesOrderId;
    }

    public Integer getuCarsId() {
        return uCarsId;
    }

    public void setuCarsId(Integer uCarsId) {
        this.uCarsId = uCarsId;
    }

    public String getuRecommend() {
        return uRecommend;
    }

    public void setuRecommend(String uRecommend) {
        this.uRecommend = uRecommend;
    }

    public Integer getWhetherBusinessmen() {
        return whetherBusinessmen;
    }

    public void setWhetherBusinessmen(Integer whetherBusinessmen) {
        this.whetherBusinessmen = whetherBusinessmen;
    }

    public Integer getBusinessmenId() {
        return businessmenId;
    }

    public void setBusinessmenId(Integer businessmenId) {
        this.businessmenId = businessmenId;
    }

    public LocalDateTime getuUpdateTime() {
        return uUpdateTime;
    }

    public void setuUpdateTime(LocalDateTime uUpdateTime) {
        this.uUpdateTime = uUpdateTime;
    }

    public Integer getuMealReservationId() {
        return uMealReservationId;
    }

    public void setuMealReservationId(Integer uMealReservationId) {
        this.uMealReservationId = uMealReservationId;
    }

    public BigDecimal getuBalance() {
        return uBalance;
    }

    public void setuBalance(BigDecimal uBalance) {
        this.uBalance = uBalance;
    }

    @Override
    public String toString() {
        return "User{" +
            "uId = " + uId +
            ", uPwd = " + uPwd +
            ", uName = " + uName +
            ", uAge = " + uAge +
            ", uAddress = " + uAddress +
            ", uFlavours = " + uFlavours +
            ", uPreferences = " + uPreferences +
            ", uCareers = " + uCareers +
            ", uDelete = " + uDelete +
            ", uCreatetime = " + uCreatetime +
            ", uHistoriesOrderId = " + uHistoriesOrderId +
            ", uCarsId = " + uCarsId +
            ", uRecommend = " + uRecommend +
            ", whetherBusinessmen = " + whetherBusinessmen +
            ", businessmenId = " + businessmenId +
            ", uUpdateTime = " + uUpdateTime +
            ", uMealReservationId = " + uMealReservationId +
            ", uBalance = " + uBalance +
        "}";
    }
}
