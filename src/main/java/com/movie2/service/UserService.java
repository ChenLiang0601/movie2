package com.movie2.service;

import com.movie2.bean.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
    boolean deleteUser(Integer id);

    //用户登录
    User userLogin(String username,String password);

//    User register(String username, String password, Integer age, String sex, Integer phonenymber, Integer t_id);
}
