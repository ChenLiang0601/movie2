package com.movie2.service;

import com.movie2.bean.Movies;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public interface MoviesService extends IService<Movies> {
    /**
     * 通过名字模糊查找电影
     */
    List<Movies> findMovie(String name);

    /**
     * 查找全部电影
     * @return
     */
    List<Movies> findAllMovies();
    /**
     * 删除电影
     */
    boolean deleteMovie(Integer movieId);

    /**
     * 修改电影信息
     * @return
     */
    boolean updateMovie(Movies movies);

    /**
     * 增加电影信息
     * @return
     */
    boolean addMovie(Movies movies);
}
