package com.movie2.service;

import com.movie2.bean.User;
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
public interface UserService extends IService<User> {

    //    注册
    boolean register(User user);

    //删除用户
    boolean deleteUser(Integer user_id);

    //用户登录
    User userLogin(String username,String password);

/**
 * 修改用户信息
 */
    boolean updateUser(User user);

/**
 * 查找所有用户
 */
    List<User> findAllUser();

    /*
    * 管理员查找用户
    * */
    List<User> findUserByUsername(String username);
}
