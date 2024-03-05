package com.example.graduationproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
@TableName(value ="user", autoResultMap = true)
@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "u_id", type = IdType.AUTO)
    private Integer uId;

    /**
     * 用户名
     */
    private String uName;

    /**
     * 用户密码
     */
    private String uPwd;

    /**
     * 用户年龄
     */
    private Integer uAge;

    /**
     * 用户地址
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private List<String> uAddress;

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
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime uCreatetime;

    /**
     * 用户智能推荐
     */
    private String uRecommend;

    /**
     * 是否是商家 是： 1 不是 0
     */


    /**
     * 用户更新时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime uUpdateTime;

    /**
     * 用户余额
     */
    private BigDecimal uBalance;

    /**
     * 省份
     */
    private String uProvince;

    private String uAvatar;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public Integer getuAge() {
        return uAge;
    }

    public void setuAge(Integer uAge) {
        this.uAge = uAge;
    }

    public List<String> getuAddress() {
        return uAddress;
    }

    public void setuAddress(List<String> uAddress) {
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

    public String getuRecommend() {
        return uRecommend;
    }

    public void setuRecommend(String uRecommend) {
        this.uRecommend = uRecommend;
    }


    public LocalDateTime getuUpdateTime() {
        return uUpdateTime;
    }

    public void setuUpdateTime(LocalDateTime uUpdateTime) {
        this.uUpdateTime = uUpdateTime;
    }

    public BigDecimal getuBalance() {
        return uBalance;
    }

    public void setuBalance(BigDecimal uBalance) {
        this.uBalance = uBalance;
    }

    public String getuProvince() {
        return uProvince;
    }

    public void setuProvince(String uProvince) {
        this.uProvince = uProvince;
    }

    public String getuAvatar() {
        return uAvatar;
    }

    public void setuAvatar(String uAvatar) {
        this.uAvatar = uAvatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPwd='" + uPwd + '\'' +
                ", uAge=" + uAge +
                ", uAddress=" + uAddress +
                ", uFlavours='" + uFlavours + '\'' +
                ", uPreferences='" + uPreferences + '\'' +
                ", uCareers='" + uCareers + '\'' +
                ", uDelete=" + uDelete +
                ", uCreatetime=" + uCreatetime +
                ", uRecommend='" + uRecommend + '\'' +
                ", uUpdateTime=" + uUpdateTime +
                ", uBalance=" + uBalance +
                ", uProvince='" + uProvince + '\'' +
                ", uAvatar='" + uAvatar + '\'' +
                '}';
    }

    //
//    public Integer getuId() {
//        return uId;
//    }
//
//    public void setuId(Integer uId) {
//        this.uId = uId;
//    }
//
//    public String getuName() {
//        return uName;
//    }
//
//    public void setuName(String uName) {
//        this.uName = uName;
//    }
//
//    public String getuPwd() {
//        return uPwd;
//    }
//
//    public void setuPwd(String uPwd) {
//        this.uPwd = uPwd;
//    }
//
//    public Integer getuAge() {
//        return uAge;
//    }
//
//    public void setuAge(Integer uAge) {
//        this.uAge = uAge;
//    }
//
//    public List<String> getuAddress() {
//        return uAddress;
//    }
//
//    public void setuAddress(List<String> uAddress) {
//        this.uAddress = uAddress;
//    }
//
//    public String getuFlavours() {
//        return uFlavours;
//    }
//
//    public void setuFlavours(String uFlavours) {
//        this.uFlavours = uFlavours;
//    }
//
//    public String getuPreferences() {
//        return uPreferences;
//    }
//
//    public void setuPreferences(String uPreferences) {
//        this.uPreferences = uPreferences;
//    }
//
//    public String getuCareers() {
//        return uCareers;
//    }
//
//    public void setuCareers(String uCareers) {
//        this.uCareers = uCareers;
//    }
//
//    public Integer getuDelete() {
//        return uDelete;
//    }
//
//    public void setuDelete(Integer uDelete) {
//        this.uDelete = uDelete;
//    }
//
//    public LocalDateTime getuCreatetime() {
//        return uCreatetime;
//    }
//
//    public void setuCreatetime(LocalDateTime uCreatetime) {
//        this.uCreatetime = uCreatetime;
//    }
//
//    public String getuRecommend() {
//        return uRecommend;
//    }
//
//    public void setuRecommend(String uRecommend) {
//        this.uRecommend = uRecommend;
//    }
//
//    public Integer getWhetherBusinessmen() {
//        return whetherBusinessmen;
//    }
//
//    public void setWhetherBusinessmen(Integer whetherBusinessmen) {
//        this.whetherBusinessmen = whetherBusinessmen;
//    }
//
//    public LocalDateTime getuUpdateTime() {
//        return uUpdateTime;
//    }
//
//    public void setuUpdateTime(LocalDateTime uUpdateTime) {
//        this.uUpdateTime = uUpdateTime;
//    }
//
//    public BigDecimal getuBalance() {
//        return uBalance;
//    }
//
//    public void setuBalance(BigDecimal uBalance) {
//        this.uBalance = uBalance;
//    }
//
//    public String getuProvince() {
//        return uProvince;
//    }
//
//    public void setuProvince(String uProvince) {
//        this.uProvince = uProvince;
//    }
//
//    public String getuAvatar() {
//        return uAvatar;
//    }
//
//    public void setuAvatar(String uAvatar) {
//        this.uAvatar = uAvatar;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "uId=" + uId +
//                ", uName='" + uName + '\'' +
//                ", uPwd='" + uPwd + '\'' +
//                ", uAge=" + uAge +
//                ", uAddress=" + uAddress +
//                ", uFlavours='" + uFlavours + '\'' +
//                ", uPreferences='" + uPreferences + '\'' +
//                ", uCareers='" + uCareers + '\'' +
//                ", uDelete=" + uDelete +
//                ", uCreatetime=" + uCreatetime +
//                ", uRecommend='" + uRecommend + '\'' +
//                ", whetherBusinessmen=" + whetherBusinessmen +
//                ", uUpdateTime=" + uUpdateTime +
//                ", uBalance=" + uBalance +
//                ", uProvince='" + uProvince + '\'' +
//                ", uAvatar='" + uAvatar + '\'' +
//                '}';
//    }
}
