package com.movie2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.movie2.bean.UserType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserTypeMapper extends BaseMapper<UserType> {

    Integer addUType(@Param("userTypes") List<UserType> userTypes);
    Integer deleteByUsername(@Param("username") String username);
    Integer updateUtype(@Param("userTypes") List<UserType> userTypes);
    List<UserType> findUserType(@Param("username") String username);

}
