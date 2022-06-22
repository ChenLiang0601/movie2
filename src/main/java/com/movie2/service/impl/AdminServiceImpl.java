package com.movie2.service.impl;

import com.movie2.bean.*;
import com.movie2.mapper.*;
import com.movie2.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.movie2.vo.adminMovieVo;
import com.movie2.vo.dataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
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
    @Autowired
    UserMapper userMapper;
    @Autowired
    TypesMapper typesMapper;
    @Autowired
    CommentViewMapper commentViewMapper;
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

    @Override
    public dataVo<User> findUser(int pageNum, int pageSize) {
        dataVo dataVo=new dataVo();
        dataVo.setCode(0);
        dataVo.setMsg("");
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<User> pageInfo = new PageInfo(userMapper.findAllUser());
        dataVo.setCount(pageInfo.getTotal());
        dataVo.setData(pageInfo.getList());
        return dataVo;
    }

    @Override
    public dataVo<User> searchUser(int pageNum, int pageSize, String username) {
        dataVo dataVo=new dataVo();
        dataVo.setCode(0);
        dataVo.setMsg("");
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<User> pageInfo = new PageInfo(userMapper.findUserByUsername(username));
        dataVo.setCount(pageInfo.getTotal());
        dataVo.setData(pageInfo.getList());
        return dataVo;
    }

    @Override
    public dataVo<Types> findTypes(int pageNum, int pageSize) {
        dataVo dataVo=new dataVo();
        dataVo.setCode(0);
        dataVo.setMsg("");
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Types> pageInfo = new PageInfo(typesMapper.selectList(null));
        dataVo.setCount(pageInfo.getTotal());
        dataVo.setData(pageInfo.getList());
        return dataVo;
    }

    @Override
    public dataVo<Types> searchTypes(int pageNum, int pageSize, String type) {
        dataVo dataVo=new dataVo();
        dataVo.setCode(0);
        dataVo.setMsg("");
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Types> pageInfo = new PageInfo(typesMapper.findType(type));
        dataVo.setCount(pageInfo.getTotal());
        dataVo.setData(pageInfo.getList());
        return dataVo;
    }

    @Override
    public dataVo<CommentView> findComments(int pageNum, int pageSize) {
        dataVo dataVo=new dataVo();
        dataVo.setCode(0);
        dataVo.setMsg("");
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<CommentView> pageInfo = new PageInfo(commentViewMapper.findAllComments());
        dataVo.setCount(pageInfo.getTotal());
        dataVo.setData(pageInfo.getList());
        return dataVo;
    }

    @Override
    public dataVo<CommentView> searComments(int pageNum, int pageSize, String comment) {
        dataVo dataVo=new dataVo();
        dataVo.setCode(0);
        dataVo.setMsg("");
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<CommentView> pageInfo = new PageInfo(commentViewMapper.findComment(comment));
        dataVo.setCount(pageInfo.getTotal());
        dataVo.setData(pageInfo.getList());
        return dataVo;
    }
}
