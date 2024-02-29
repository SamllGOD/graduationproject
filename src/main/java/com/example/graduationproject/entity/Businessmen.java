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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@Getter
@Setter
@TableName(value ="businessmen", autoResultMap = true)
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
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;

    private String buTablepto;

    private String bName;

    private String bPwd;

    private String bAvatar;

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

    public String getBuTablepto() {
        return buTablepto;
    }

    public void setBuTablepto(String buTablepto) {
        this.buTablepto = buTablepto;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbPwd() {
        return bPwd;
    }

    public void setbPwd(String bPwd) {
        this.bPwd = bPwd;
    }

    public String getuAvatar() {
        return bAvatar;
    }

    public void setuAvatar(String uAvatar) {
        this.bAvatar = uAvatar;
    }

    @Override
    public String toString() {
        return "Businessmen{" +
                "businessmenId=" + businessmenId +
                ", businessmenName='" + businessmenName + '\'' +
                ", businessPrice=" + businessPrice +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", buTablepto='" + buTablepto + '\'' +
                ", bName='" + bName + '\'' +
                ", bPwd='" + bPwd + '\'' +
                ", uAvatar='" + bAvatar + '\'' +
                '}';
    }
}


