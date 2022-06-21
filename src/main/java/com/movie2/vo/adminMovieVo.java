package com.movie2.vo;

import com.movie2.bean.Types;
import lombok.Data;

@Data
public class adminMovieVo {
    private Integer movieId;
    private String name;
    private String releaseDate;
    private Integer score;
    private String introduction;
    private String heat;
    private String director;
    private String actor;
    private String image;
    private String types;
}
