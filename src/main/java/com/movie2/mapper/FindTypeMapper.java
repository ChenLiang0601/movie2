package com.movie2.mapper;

import com.movie2.bean.FindType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * VIEW Mapper 接口
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public interface FindTypeMapper extends BaseMapper<FindType> {

FindType findUser(@Param("username") String username);
}
