package com.movie2.service;

import com.movie2.bean.Movies;
import com.movie2.bean.Types;
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
public interface TypesService extends IService<Types> {
//    添加类型
    Integer addType(String type);

    //删除类型
    boolean deleteType(Integer type_id);

    /**
     * 修改电影类型信息
     * @return
     */
    boolean updateTypes(Types types);

    /**
     * 模糊查找类型
     * @param type
     * @return
     */
    List<Types> findType(String type);
    /**
    * 查找所有类型
    * */
    List<Types> findAllTypes();
}
