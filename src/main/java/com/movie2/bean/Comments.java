package com.movie2.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public class Comments extends Model<Comments> {

    private static final long serialVersionUID=1L;

    @TableId(value = "comments_id", type = IdType.AUTO)
    private Integer commentsId;

    private Integer userId;

    private String comment;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;

    private Integer movieId;


    public Integer getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(Integer commentsId) {
        this.commentsId = commentsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @Override
    protected Serializable pkVal() {
        return this.commentsId;
    }

    @Override
    public String toString() {
        return "Comments{" +
        "commentsId=" + commentsId +
        ", userId=" + userId +
        ", comment=" + comment +
        ", time=" + time +
        ", movieId=" + movieId +
        "}";
    }
}
