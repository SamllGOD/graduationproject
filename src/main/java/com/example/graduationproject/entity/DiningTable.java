package com.example.graduationproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("dining_table")
public class DiningTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 餐厅餐桌id
     */
    @TableId(value = "dining_table_id", type = IdType.AUTO)
    private Integer diningTableId;

    /**
     * 餐桌类型
     */
    private String tableType;

    /**
     * 可坐人数
     */
    private Integer seatingCapacity;

    /**
     * 详情
     */
    private String details;

    /**
     * 点击数
     */
    private Integer hits;

    /**
     * 智能推荐
     */
    private Integer recommend;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 餐桌照片
     */
    private String diningPhoto;

    /**
     * 餐桌名称
     */
    private String diningName;



    /**
     * 餐厅所有人即商家
     */
    private Integer diningBuid;

    public Integer getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(Integer diningTableId) {
        this.diningTableId = diningTableId;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
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

    public String getDiningPhoto() {
        return diningPhoto;
    }

    public void setDiningPhoto(String diningPhoto) {
        this.diningPhoto = diningPhoto;
    }

    public String getDiningName() {
        return diningName;
    }

    public void setDiningName(String diningName) {
        this.diningName = diningName;
    }

    public Integer getDiningBuid() {
        return diningBuid;
    }

    public void setDiningBuid(Integer diningBuid) {
        this.diningBuid = diningBuid;
    }

    @Override
    public String toString() {
        return "DiningTable{" +
            "diningTableId = " + diningTableId +
            ", tableType = " + tableType +
            ", seatingCapacity = " + seatingCapacity +
            ", details = " + details +
            ", hits = " + hits +
            ", recommend = " + recommend +
            ", createTime = " + createTime +
            ", updateTime = " + updateTime +
            ", diningPhoto = " + diningPhoto +
            ", diningName = " + diningName +

            ", diningBuid = " + diningBuid +
        "}";
    }
}
