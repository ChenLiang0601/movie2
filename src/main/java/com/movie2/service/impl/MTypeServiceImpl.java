package com.movie2.service.impl;

import com.movie2.bean.MType;
import com.movie2.mapper.MTypeMapper;
import com.movie2.service.MTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
@Service
public class MTypeServiceImpl extends ServiceImpl<MTypeMapper, MType> implements MTypeService {

    @Resource
    MTypeMapper mTypeMapper;
    @Override
    public MType movieinfo(Integer movieId) {
        return mTypeMapper.movieInfo(movieId);
    }
}
