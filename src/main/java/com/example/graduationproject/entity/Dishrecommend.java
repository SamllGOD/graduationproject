package com.example.graduationproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@TableName(value ="dishrecommend", autoResultMap = true)
public class Dishrecommend implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "dishrecommend_id", type = IdType.AUTO)
    private Integer dishrecommendId;

    private  Integer recommendUserid;

    private  Integer recommendDishid;


    public Integer getDishrecommendId() {
        return dishrecommendId;
    }

    public void setDishrecommendId(Integer dishrecommendId) {
        this.dishrecommendId = dishrecommendId;
    }

    public Integer getRecommendUserid() {
        return recommendUserid;
    }

    public void setRecommendUserid(Integer recommendUserid) {
        this.recommendUserid = recommendUserid;
    }

    public Integer getRecommendDishid() {
        return recommendDishid;
    }

    public void setRecommendDishid(Integer recommendDishid) {
        this.recommendDishid = recommendDishid;
    }

    @Override
    public String toString() {
        return "Dishrecommend{" +
                "dishrecommendId=" + dishrecommendId +
                ", recommendUserid=" + recommendUserid +
                ", recommendDishid=" + recommendDishid +
                '}';
    }
}
