package com.movie2.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.movie2.bean.Movies;
import com.movie2.service.MoviesService;
import com.movie2.service.UserService;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Resource
    private MoviesService moviesService;

    /**
     * 电影根据名字模糊查找
     * @param name
     * @return
     */
    @RequestMapping(value ="test" ,method = RequestMethod.GET)
    public List<Movies> findByName(@RequestParam("name") String name){
        return moviesService.findMovie(name);
    }

    /**
     * 显示所有电影
     * @return
     */
    @RequestMapping(value = "test2",method = RequestMethod.GET)
    public List<Movies> findAllMovies()
    {
        return moviesService.findAllMovies();
    }
    /**
     * 删除电影
     */
    @RequestMapping(value = "test3",method = RequestMethod.DELETE)
    public boolean deleteMovie(@RequestParam("movieId") Integer movieId)
    {
        return  moviesService.deleteMovie(movieId);
    }

    /**
     * 修改电影
     */
    @RequestMapping(value = "test4",method = RequestMethod.POST)
    public boolean updateMovie(Movies movies)
    {
        return moviesService.updateMovie(movies);
    }

    /**
     * 添加电影
     */
    @RequestMapping(value = "test5",method = RequestMethod.POST)
    public boolean addMovie(Movies movies)
    {
        return moviesService.addMovie(movies);
    }
}
