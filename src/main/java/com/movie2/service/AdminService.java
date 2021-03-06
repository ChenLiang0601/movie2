package com.movie2.service;

import com.movie2.bean.*;
import com.baomidou.mybatisplus.extension.service.IService;
import com.movie2.vo.adminMovieVo;
import com.movie2.vo.dataVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public interface AdminService extends IService<Admin> {
/*
* 管理员登录
* */
    Admin adminLogin(String adminUsername,String adminPwd);
    dataVo<adminMovieVo> finddata(int pageNum, int pageSize);
    dataVo<adminMovieVo> searchMovie(int pageNum, int pageSize,String name);
    dataVo<User> findUser(int pageNum, int pageSize);
    dataVo<User> searchUser(int pageNum, int pageSize,String username);
    dataVo<Types> findTypes(int pageNum, int pageSize);
    dataVo<Types> searchTypes(int pageNum, int pageSize,String type);
    dataVo<CommentView> findComments(int pageNum, int pageSize);
    dataVo<CommentView> searComments(int pageNum, int pageSize,String comment);
}
