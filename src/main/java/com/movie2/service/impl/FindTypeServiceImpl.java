package com.movie2.service.impl;

import com.movie2.bean.FindType;
import com.movie2.mapper.FindTypeMapper;
import com.movie2.service.FindTypeService;
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
public class FindTypeServiceImpl extends ServiceImpl<FindTypeMapper, FindType> implements FindTypeService {

    @Resource
    FindTypeMapper findTypeMapper;
    /*根据用户名查找用户信息*/
    @Override
    public FindType findUser(String username) {
           return findTypeMapper.findUser(username);

    }

}
