package com.movie2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.movie2.bean.UserType;

public interface UserTypeService extends IService<UserType> {

    /**
     * 添加
     */
    boolean addUType(UserType userType);

    /**
     * 删除
     * @param username
     * @return
     */
    boolean deleteUType(String username);

    /**
     * 修改
     */
    boolean updateUType(UserType userType);
}
