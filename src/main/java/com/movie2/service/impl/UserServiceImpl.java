package com.movie2.service.impl;

import com.movie2.bean.User;
import com.movie2.mapper.UserMapper;
import com.movie2.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
     UserMapper userMapper;

//    @Override
//    public boolean register(String user) {
//        boolean flag=false;
//        try{
//            userDao.save(user);
//            flag=true;
//        }catch(Exception e){
//            System.out.println("新增失败!");
//            e.printStackTrace();
//        }
//        return flag;
//    }

    @Override
    public boolean register(User user) {
        boolean flag=false;
        try{
            userMapper.insert(user);
            flag=true;
        }catch(Exception e){
            System.out.println("新增失败!");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return false;
    }



    @Override
    public User userLogin(String username,String password) {
        return userMapper.findByUsernameAndPassword(username,password);
    }

//    @Override
//    public User register(String username, String password, Integer age, String sex, Integer phonenymber, Integer type_id) {
//        return userMapper.register(username,password,age,sex,phonenymber,type_id);
//    }

}
