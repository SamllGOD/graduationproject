package com.example.graduationproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
@TableName(value = "meal_reservation",autoResultMap = true)
public class MealReservation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 就餐预约id
     */
    @TableId(value = "meal_reservation_id", type = IdType.AUTO)
    private Integer mealReservationId;

    /**
     * 就餐时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime realTime;

    /**
     * 联系电话
     */
    private String contactNumber;

    /**
     * 审核状态 0未审核 1通过 2未通过
     */
    private Integer examineState;

    /**
     * 审核回复
     */
    private String examineReply;

    /**
     * 创建时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;

    /**
     * 就餐人数
     */
    private Integer numberOfDiners;

    /**
     * 订单id
     */
    private Integer mealOrderid;

    public Integer getMealReservationId() {
        return mealReservationId;
    }

    public void setMealReservationId(Integer mealReservationId) {
        this.mealReservationId = mealReservationId;
    }

    public LocalDateTime getRealTime() {
        return realTime;
    }

    public void setRealTime(LocalDateTime realTime) {
        this.realTime = realTime;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getExamineState() {
        return examineState;
    }

    public void setExamineState(Integer examineState) {
        this.examineState = examineState;
    }

    public String getExamineReply() {
        return examineReply;
    }

    public void setExamineReply(String examineReply) {
        this.examineReply = examineReply;
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

    public Integer getNumberOfDiners() {
        return numberOfDiners;
    }

    public void setNumberOfDiners(Integer numberOfDiners) {
        this.numberOfDiners = numberOfDiners;
    }

    public Integer getMealOrderid() {
        return mealOrderid;
    }

    public void setMealOrderid(Integer mealOrderid) {
        this.mealOrderid = mealOrderid;
    }

    @Override
    public String toString() {
        return "MealReservation{" +
            "mealReservationId = " + mealReservationId +
            ", realTime = " + realTime +
            ", contactNumber = " + contactNumber +
            ", examineState = " + examineState +
            ", examineReply = " + examineReply +
            ", createTime = " + createTime +
            ", updateTime = " + updateTime +
            ", numberOfDiners = " + numberOfDiners +
            ", mealOrderid = " + mealOrderid +
        "}";
    }
}
