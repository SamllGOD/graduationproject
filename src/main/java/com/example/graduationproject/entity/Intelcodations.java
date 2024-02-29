package com.example.graduationproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
@TableName(value = "dish_information", autoResultMap = true)
@Getter
@Setter
public class Intelcodations implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 智能推荐id 推荐的数据
     */
    @TableId(value = "intereda_id", type = IdType.AUTO)
    private Integer interedaId;

    /**
     * 地理位置
     */
    private String interedaGelo;

    /**
     * 职业推荐
     */
    private String careers;

    public Integer getInteredaId() {
        return interedaId;
    }

    public void setInteredaId(Integer interedaId) {
        this.interedaId = interedaId;
    }

    public String getInteredaGelo() {
        return interedaGelo;
    }

    public void setInteredaGelo(String interedaGelo) {
        this.interedaGelo = interedaGelo;
    }

    public String getCareers() {
        return careers;
    }

    public void setCareers(String careers) {
        this.careers = careers;
    }

    @Override
    public String toString() {
        return "Intelcodations{" +
            "interedaId = " + interedaId +
            ", interedaGelo = " + interedaGelo +
            ", careers = " + careers +
        "}";
    }
}
