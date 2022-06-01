package com.movie2.mapper;

import com.movie2.bean.User;
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
public interface UserMapper extends BaseMapper<User> {
    User findByUsernameAndPassword(@Param("username") String username,@Param("password")  String password);

//    void save(User user);

//    boolean register(User user);

//    User register(@Param("username") String username, @Param("password")  String password, @Param("age") Integer age,
//                  @Param("sex") String sex, @Param("phonenumber") Integer phonenymber, @Param("type_id") Integer type_id);
}
