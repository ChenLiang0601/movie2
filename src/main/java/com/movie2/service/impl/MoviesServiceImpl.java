package com.movie2.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.movie2.bean.Movies;
import com.movie2.bean.Types;
import com.movie2.mapper.MoviesMapper;
import com.movie2.mapper.TypesMapper;
import com.movie2.service.MoviesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
@Service
public class MoviesServiceImpl extends ServiceImpl<MoviesMapper, Movies> implements MoviesService {
    @Autowired
    MoviesMapper moviesMapper;
    @Autowired
    TypesMapper typesMapper;
    @Override
    public List<Movies> findMovie(String name) {
        return moviesMapper.findByName(name);
    }

    @Override
    public List<Movies> findAllMovies(){
        return moviesMapper.findAllMovies();
    }

    @Override
    public Movies findById(Integer movieId) {
        return moviesMapper.findById(movieId);
    }

    @Override
    public boolean deleteMovie(Integer movieId) {
        boolean flag=false;
        try{
            moviesMapper.deleteById(movieId);
            flag=true;
        }catch(Exception e){
            System.out.println("删除失败!");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateMovie(Movies movies) {
        boolean flag=false;
        try{
            moviesMapper.updateById(movies);
            flag=true;
        }catch(Exception e){
            System.out.println("修改失败!");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean addMovie(Movies movies) {
        boolean flag=false;
        JSONObject result = new JSONObject();
        try{
            moviesMapper.insert(movies);
            flag=true;
        }catch(Exception e){
            System.out.println("添加失败!");
            e.printStackTrace();
        }
        return flag;
    }
}
