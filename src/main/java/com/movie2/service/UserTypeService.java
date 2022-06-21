package com.movie2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.movie2.bean.UserType;

import java.util.List;

public interface UserTypeService extends IService<UserType> {

    /**
     * 添加
     */
    Integer addUType(List<UserType> userType);
    /**
     * 删除
     * @param username
     * @return
     */
    boolean deleteUType(String username);

    /**
     * 修改
     */
    Integer updateUType(List<UserType> userType);
    /**
     * 查找
     */
    List<UserType> findUserType(String username);
}
