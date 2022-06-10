package com.movie2.service.impl;

import com.movie2.bean.User;
import com.movie2.mapper.CommentsMapper;
import com.movie2.mapper.ScoresMapper;
import com.movie2.mapper.UserMapper;
import com.movie2.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    @Resource
    ScoresMapper scoresMapper;
    @Resource
    CommentsMapper commentsMapper;


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
    public boolean deleteUser(Integer user_id) {
        boolean flag=false;
        try{
//            commentsMapper.deleteById(user_id);
//            scoresMapper.deleteById(user_id);
            userMapper.deleteById(user_id);
            flag=true;
        }catch(Exception e){
            System.out.println("删除失败user service!");
            e.printStackTrace();
        }
        return flag;
    }
//    @Override
//    public boolean deleteScore(Integer user_id) {
//        boolean flag=false;
//        try{
////            commentsMapper.deleteById(user_id);
//            scoresMapper.deleteById(user_id);
////            userMapper.deleteById(user_id);
//            flag=true;
//        }catch(Exception e){
//            System.out.println("删除失败!");
//            e.printStackTrace();
//        }
//        return flag;
//    }
//    @Override
//    public boolean deleteUser(Integer user_id) {
//        boolean flag=false;
//        try{
//            commentsMapper.deleteById(user_id);
//            scoresMapper.deleteById(user_id);
//            userMapper.deleteById(user_id);
//            flag=true;
//        }catch(Exception e){
//            System.out.println("删除失败!");
//            e.printStackTrace();
//        }
//        return flag;
//    }




    @Override
    public User userLogin(String username,String password) {
        return userMapper.findByUsernameAndPassword(username,password);
    }

//    @Override
//    public User register(String username, String password, Integer age, String sex, Integer phonenymber, Integer type_id) {
//        return userMapper.register(username,password,age,sex,phonenymber,type_id);
//    }

}
