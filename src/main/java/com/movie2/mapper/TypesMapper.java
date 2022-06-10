package com.movie2.mapper;

import com.movie2.bean.Types;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public interface TypesMapper extends BaseMapper<Types> {

    Integer addType(@Param("type") String type);
}
