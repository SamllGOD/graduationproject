package com.example.graduationproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;

@TableName("table_info")
public class TableInfo {

    private static final long serialVersionUID = 1L;
    @TableId(value = "table_id", type = IdType.AUTO)
    private Integer tableId;

         private Integer tableNumber;

         private Integer tableDiningid;

         private Integer tableuse;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime tableCreatetime;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime tableUpdatetime;


    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Integer getTableDiningid() {
        return tableDiningid;
    }

    public void setTableDiningid(Integer tableDiningid) {
        this.tableDiningid = tableDiningid;
    }

    public Integer getTableuse() {
        return tableuse;
    }

    public void setTableuse(Integer tableuse) {
        this.tableuse = tableuse;
    }

    public LocalDateTime getTableCreatetime() {
        return tableCreatetime;
    }

    public void setTableCreatetime(LocalDateTime tableCreatetime) {
        this.tableCreatetime = tableCreatetime;
    }

    public LocalDateTime getTableUpdatetime() {
        return tableUpdatetime;
    }

    public void setTableUpdatetime(LocalDateTime tableUpdatetime) {
        this.tableUpdatetime = tableUpdatetime;
    }

    @Override
    public String toString() {
        return "TableInfo{" +
                "tableId=" + tableId +
                ", tableNumber=" + tableNumber +
                ", tableDiningid=" + tableDiningid +
                ", tableuse=" + tableuse +
                ", tableCreatetime=" + tableCreatetime +
                ", tableUpdatetime=" + tableUpdatetime +
                '}';
    }
}
