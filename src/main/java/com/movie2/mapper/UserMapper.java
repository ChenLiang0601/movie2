package com.movie2.mapper;

import com.movie2.bean.User;
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
public interface UserMapper extends BaseMapper<User> {

    //映射文件中SQL语句的id要和mapper接口中的方法名一致
    User findByUsernameAndPassword(@Param("username") String username,@Param("password")  String password);

    List<User> findAllUser();

//    /**
//     * 修改用户信息
//     * @param user
//     */
//    void updateUser(@Param("user") User user);
}
