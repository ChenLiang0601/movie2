package com.movie2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.movie2.bean.UserType;
import org.apache.ibatis.annotations.Param;

public interface UserTypeMapper extends BaseMapper<UserType> {

    Integer addUType(UserType userType);

    Integer deleteByUsername(@Param("username") String username);
}
