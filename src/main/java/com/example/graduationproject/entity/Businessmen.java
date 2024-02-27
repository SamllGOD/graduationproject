package com.example.graduationproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xxay
 * @since 2024-02-27
 */
public class Businessmen implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商家id
     */
    @TableId(value = "businessmen_id", type = IdType.AUTO)
    private Integer businessmenId;

    /**
     * 客户订单id
     */
    private Integer orderId;

    /**
     * 菜品信息id
     */
    private Integer dishInformationId;

    /**
     * 菜品分类id
     */
    private Integer dishClassificationId;

    /**
     * 餐厅餐桌id
     */
    private Integer diningTableId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public Integer getBusinessmenId() {
        return businessmenId;
    }

    public void setBusinessmenId(Integer businessmenId) {
        this.businessmenId = businessmenId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getDishInformationId() {
        return dishInformationId;
    }

    public void setDishInformationId(Integer dishInformationId) {
        this.dishInformationId = dishInformationId;
    }

    public Integer getDishClassificationId() {
        return dishClassificationId;
    }

    public void setDishClassificationId(Integer dishClassificationId) {
        this.dishClassificationId = dishClassificationId;
    }

    public Integer getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(Integer diningTableId) {
        this.diningTableId = diningTableId;
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

    @Override
    public String toString() {
        return "Businessmen{" +
            "businessmenId = " + businessmenId +
            ", orderId = " + orderId +
            ", dishInformationId = " + dishInformationId +
            ", dishClassificationId = " + dishClassificationId +
            ", diningTableId = " + diningTableId +
            ", createTime = " + createTime +
            ", updateTime = " + updateTime +
        "}";
    }
}
