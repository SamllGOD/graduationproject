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

@Getter
@Setter
@TableName(value ="dishrecommend", autoResultMap = true)
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "comments_id", type = IdType.AUTO)
    private Integer commentsId;

    private Integer commentsNumber;

    private String commentsContent;

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


    private String commentsFollow;

    private String commentsReply;

    private Integer commentsUserId;

    private Integer commentsDe;

    private Integer commentsOrderid;


    public Integer getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(Integer commentsId) {
        this.commentsId = commentsId;
    }

    public Integer getCommentsNumber() {
        return commentsNumber;
    }

    public void setCommentsNumber(Integer commentsNumber) {
        this.commentsNumber = commentsNumber;
    }

    public String getCommentsContent() {
        return commentsContent;
    }

    public void setCommentsContent(String commentsContent) {
        this.commentsContent = commentsContent;
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

    public String getCommentsFollow() {
        return commentsFollow;
    }

    public void setCommentsFollow(String commentsFollow) {
        this.commentsFollow = commentsFollow;
    }

    public String getCommentsReply() {
        return commentsReply;
    }

    public void setCommentsReply(String commentsReply) {
        this.commentsReply = commentsReply;
    }

    public Integer getCommentsUserId() {
        return commentsUserId;
    }

    public void setCommentsUserId(Integer commentsUserId) {
        this.commentsUserId = commentsUserId;
    }

    public Integer getCommentsDe() {
        return commentsDe;
    }

    public void setCommentsDe(Integer commentsDe) {
        this.commentsDe = commentsDe;
    }

    public Integer getCommentsOrderid() {
        return commentsOrderid;
    }

    public void setCommentsOrderid(Integer commentsOrderid) {
        this.commentsOrderid = commentsOrderid;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "commentsId=" + commentsId +
                ", commentsNumber=" + commentsNumber +
                ", commentsContent='" + commentsContent + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", commentsFollow='" + commentsFollow + '\'' +
                ", commentsReply='" + commentsReply + '\'' +
                ", commentsUserId=" + commentsUserId +
                ", commentsDe=" + commentsDe +
                ", commentsOrderid=" + commentsOrderid +
                '}';
    }
}
