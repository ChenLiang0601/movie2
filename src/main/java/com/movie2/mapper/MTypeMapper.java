package com.movie2.mapper;

import com.movie2.bean.MType;
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
public interface MTypeMapper extends BaseMapper<MType> {
 MType movieInfo(@Param("movie_id") Integer movie_id);
}
