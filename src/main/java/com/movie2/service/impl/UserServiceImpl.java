package com.movie2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.movie2.bean.FindType;
import com.movie2.bean.User;
import com.movie2.mapper.CommentsMapper;
import com.movie2.mapper.FindTypeMapper;
import com.movie2.mapper.ScoresMapper;
import com.movie2.mapper.UserMapper;
import com.movie2.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
            userMapper.deleteById(user_id);
            flag=true;
        }catch(Exception e){
            System.out.println("删除失败user service!");
            e.printStackTrace();
        }
        return flag;
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User userLogin(String username,String password) {
        return userMapper.findByUsernameAndPassword(username,password);
    }
/*更新用户信息*/
    @Override
    public boolean updateUser(User user) {
        boolean flag=false;
        try{

            userMapper.updateById(user);
            flag=true;
            System.out.println("修改成功");
        }catch(Exception e){
            System.out.println("修改失败!");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public List<User> findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

}
