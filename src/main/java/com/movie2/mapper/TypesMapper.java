package com.movie2.mapper;

import com.movie2.bean.Types;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public interface TypesMapper extends BaseMapper<Types> {
/**
* 添加电影类型
* */
    Integer addType(@Param("type") String type);
    /**
    * 查找所有电影类型
    * */
    List<Types> findAllTypes();
    /**
    * 查找单个类型（模糊查找）
    * */
    List<Types> findType(@Param("type") String type);
}
