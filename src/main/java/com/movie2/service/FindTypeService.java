package com.movie2.service;

import com.movie2.bean.FindType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.movie2.bean.User;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public interface FindTypeService extends IService<FindType> {
    /**
     * 根据ID查找用户信息
     */
    FindType findUser(String username);

}
