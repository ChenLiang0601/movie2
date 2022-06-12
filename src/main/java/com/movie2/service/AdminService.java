package com.movie2.service;

import com.movie2.bean.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
