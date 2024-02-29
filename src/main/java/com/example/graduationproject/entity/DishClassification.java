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
@Getter
@Setter
@TableName(value ="dish_classification", autoResultMap = true)
public class DishClassification implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜品分类id
     */
    @TableId(value = "dish_classification_id", type = IdType.AUTO)
    private Integer dishClassificationId;

    /**
     * 菜品类别
     */
    private String dishCategory;

    /**
     * 智能推荐
     */
    private Integer recommend;

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
     * 商家id
     */
    private Integer dishclaBuid;

    public Integer getDishClassificationId() {
        return dishClassificationId;
    }

    public void setDishClassificationId(Integer dishClassificationId) {
        this.dishClassificationId = dishClassificationId;
    }

    public String getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(String dishCategory) {
        this.dishCategory = dishCategory;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
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

    public Integer getDishclaBuid() {
        return dishclaBuid;
    }

    public void setDishclaBuid(Integer dishclaBuid) {
        this.dishclaBuid = dishclaBuid;
    }

    @Override
    public String toString() {
        return "DishClassification{" +
            "dishClassificationId = " + dishClassificationId +
            ", dishCategory = " + dishCategory +
            ", recommend = " + recommend +
            ", createTime = " + createTime +
            ", updateTime = " + updateTime +
            ", dishclaBuid = " + dishclaBuid +
        "}";
    }
}
