package com.movie2.service.impl;

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

@Service
public class UserTypeServiceImpl extends ServiceImpl<UserTypeMapper, UserType> implements UserTypeService {
    @Resource
    UserTypeMapper userTypeMapper;

    @Override
    public boolean addUType(UserType userType) {
        boolean flag=false;
        try{

            userTypeMapper.addUType(userType);
            flag=true;
        }catch(Exception e){
            System.out.println("新增失败!");
            e.printStackTrace();
        }
        return flag;
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
    public boolean updateUType(UserType userType) {
        boolean flag=false;
        try{

            userTypeMapper.updateById(userType);
            flag=true;
            System.out.println("修改成功");
        }catch(Exception e){
            System.out.println("修改失败!");
            e.printStackTrace();
        }
        return flag;
    }
}
