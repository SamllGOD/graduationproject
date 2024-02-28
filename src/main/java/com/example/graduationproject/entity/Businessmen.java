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
 * @since 2024-02-28
 */
public class Businessmen implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商家id
     */
    @TableId(value = "businessmen_id", type = IdType.AUTO)
    private Integer businessmenId;

    /**
     * 商家名
     */
    private String businessmenName;

    /**
     * 商家金额
     */
    private BigDecimal businessPrice;

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

    public String getBusinessmenName() {
        return businessmenName;
    }

    public void setBusinessmenName(String businessmenName) {
        this.businessmenName = businessmenName;
    }

    public BigDecimal getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(BigDecimal businessPrice) {
        this.businessPrice = businessPrice;
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
            ", businessmenName = " + businessmenName +
            ", businessPrice = " + businessPrice +
            ", createTime = " + createTime +
            ", updateTime = " + updateTime +
        "}";
    }
}
