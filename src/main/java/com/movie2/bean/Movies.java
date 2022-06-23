package com.movie2.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

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
    private String types;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    private Integer score;
    private String introduction;
    private String heat;
    private String director;
    private String actor;
    private String image;

    public Movies(Integer movieId,String name,String types,Date releaseDate,Integer score,String introduction,String heat,String director,String actor,String image){
        this.movieId=movieId;
        this.name=name;
        this.types=types;
        this.releaseDate=releaseDate;
        this.score=score;
        this.introduction=introduction;
        this.heat=heat;
        this.director=director;
        this.actor=actor;
        this.image=image;
    }

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

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        ", types=" + types +
        ", releaseDate=" + releaseDate +
        ", score=" + score +
        ", introduction=" + introduction +
        ", director=" + director +
        ", actor=" + actor +
        ", image=" + image +
        "}";
    }
}
