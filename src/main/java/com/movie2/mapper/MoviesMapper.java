package com.movie2.mapper;

import com.alibaba.fastjson.JSONObject;
import com.movie2.bean.Movies;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public interface MoviesMapper extends BaseMapper<Movies> {
    List<Movies> findByName(String name);
    List<Movies> findAllMovies();
    Movies findById(Integer movieId);
    /**
     * 最热电影
     */
    List<Movies> findByHeat();
    /**
     * 最新电影
     */
    List<Movies> findBytime();
    /**
     * 猜你喜欢
     * @param uType
     */
    List<Movies> findByType(String uType);
}
