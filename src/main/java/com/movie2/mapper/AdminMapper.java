package com.movie2.mapper;

import com.movie2.bean.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.movie2.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public interface AdminMapper extends BaseMapper<Admin> {
    //映射文件中SQL语句的id要和mapper接口中的方法名一致
    Admin adminLogin(@Param("adminUsername") String adminUsername, @Param("adminPwd")  String adminPwd);
}
