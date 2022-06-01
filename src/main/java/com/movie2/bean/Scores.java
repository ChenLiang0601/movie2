package com.movie2.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public class Scores extends Model<Scores> {

    private static final long serialVersionUID=1L;

    @TableId(value = "score_id", type = IdType.AUTO)
    private Integer scoreId;

    private Integer userId;

    private String score;


    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    protected Serializable pkVal() {
        return this.scoreId;
    }

    @Override
    public String toString() {
        return "Scores{" +
        "scoreId=" + scoreId +
        ", userId=" + userId +
        ", score=" + score +
        "}";
    }
}
