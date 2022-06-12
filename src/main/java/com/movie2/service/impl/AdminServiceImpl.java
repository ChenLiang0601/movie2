package com.movie2.service.impl;

import com.movie2.bean.Admin;
import com.movie2.mapper.AdminMapper;
import com.movie2.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    @Override
    public Admin adminLogin(String adminUsername, String adminPwd) {
        return adminMapper.adminLogin(adminUsername,adminPwd);
    }
}
