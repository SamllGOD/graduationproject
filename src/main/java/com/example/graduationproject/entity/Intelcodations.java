package com.example.graduationproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xxay
 * @since 2024-02-27
 */
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
     * 推荐菜id
     */
    private Integer interedaRealId;

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

    public Integer getInteredaRealId() {
        return interedaRealId;
    }

    public void setInteredaRealId(Integer interedaRealId) {
        this.interedaRealId = interedaRealId;
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
            ", interedaRealId = " + interedaRealId +
            ", careers = " + careers +
        "}";
    }
}
