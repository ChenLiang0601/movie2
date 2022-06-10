package com.movie2.service;

import com.movie2.bean.Types;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public interface TypesService extends IService<Types> {
//    添加类型
    Integer addType(String type);

    //删除类型
    boolean deleteType(Integer type_id);



}
