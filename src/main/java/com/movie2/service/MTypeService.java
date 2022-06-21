package com.movie2.service;

import com.movie2.bean.MType;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public interface MTypeService extends IService<MType> {
/**
 * 电影信息展示，包括电影评分
 */
 MType movieinfo(Integer movieId);
}
