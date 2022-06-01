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
public class Movies extends Model<Movies> {

    private static final long serialVersionUID=1L;

    @TableId(value = "movie_id", type = IdType.AUTO)
    private Integer movieId;

    private String name;

    private Integer typeId;

    private String releaseDate;

    private Integer score;

    private String introduction;

    private String heat;


    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getHeat() {
        return heat;
    }

    public void setHeat(String heat) {
        this.heat = heat;
    }

    @Override
    protected Serializable pkVal() {
        return this.movieId;
    }

    @Override
    public String toString() {
        return "Movies{" +
        "movieId=" + movieId +
        ", name=" + name +
        ", typeId=" + typeId +
        ", releaseDate=" + releaseDate +
        ", score=" + score +
        ", introduction=" + introduction +
        ", heat=" + heat +
        "}";
    }
}
