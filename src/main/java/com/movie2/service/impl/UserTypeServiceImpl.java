package com.movie2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.movie2.bean.User;
import com.movie2.bean.UserType;
import com.movie2.mapper.UserMapper;
import com.movie2.mapper.UserTypeMapper;
import com.movie2.service.UserService;
import com.movie2.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserTypeServiceImpl extends ServiceImpl<UserTypeMapper, UserType> implements UserTypeService {
    @Resource
    UserTypeMapper userTypeMapper;


    @Override
    public  Integer addUType(List<UserType> userType) {
        return userTypeMapper.addUType(userType);
    }

    @Override
    public boolean deleteUType(String username) {
        boolean flag=false;
        try{
            userTypeMapper.deleteByUsername(username);
            flag=true;
        }catch(Exception e){
            System.out.println("删除失败UType!");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Integer updateUType(List<UserType> userType) {
        Integer flag=0;
        try{
            userTypeMapper.updateUtype(userType);
            flag=1;
            System.out.println("修改成功");
        }catch(Exception e){
            System.out.println("修改失败!");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<UserType> findUserType(String username) {
//        QueryWrapper<UserType> queryWrapper = new QueryWrapper<>();
//        list(queryWrapper.eq("username",username));
        return userTypeMapper.findUserType(username);
    }
}
