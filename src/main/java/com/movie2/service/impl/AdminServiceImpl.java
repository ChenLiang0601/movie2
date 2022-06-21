package com.movie2.service.impl;

import com.movie2.bean.Admin;
import com.movie2.bean.Movies;
import com.movie2.mapper.AdminMapper;
import com.movie2.mapper.MoviesMapper;
import com.movie2.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.movie2.vo.adminMovieVo;
import com.movie2.vo.dataVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import java.util.ArrayList;
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
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Resource
    AdminMapper adminMapper;
    @Autowired
    MoviesMapper moviesMapper;
    @Override
    public Admin adminLogin(String adminUsername, String adminPwd) {
        return adminMapper.adminLogin(adminUsername,adminPwd);
    }

    @Override
    public dataVo<adminMovieVo> finddata(int pageNum, int pageSize) {
        dataVo dataVo=new dataVo();
        dataVo.setCode(0);
        dataVo.setMsg("");
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Movies> pageInfo = new PageInfo(moviesMapper.findAllMovies());

        dataVo.setCount(pageInfo.getTotal());

        List<Movies> moviesList= moviesMapper.findAllMovies();
        dataVo.setData(pageInfo.getList());
        return dataVo;
    }

    @Override
    public dataVo<adminMovieVo> searchMovie(int pageNum, int pageSize,String name) {
        dataVo dataVo=new dataVo();
        dataVo.setCode(0);
        dataVo.setMsg("");
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Movies> pageInfo = new PageInfo(moviesMapper.findByName(name));
        dataVo.setCount(pageInfo.getTotal());
        List<Movies> moviesList= moviesMapper.findAllMovies();
        dataVo.setData(pageInfo.getList());
        return dataVo;
    }
}
