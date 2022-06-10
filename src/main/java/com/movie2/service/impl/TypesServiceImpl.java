package com.movie2.service.impl;

import com.movie2.bean.Types;
import com.movie2.mapper.TypesMapper;
import com.movie2.service.TypesService;
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
public class TypesServiceImpl extends ServiceImpl<TypesMapper, Types> implements TypesService {
    @Resource
    TypesMapper typesMapper;

    //添加电影类型
//    @Override
//    public boolean addType(Types types){
//        boolean flag=false;
//        try{
//
//            typesMapper.insert(types);
//            flag=true;
//        }catch(Exception e){
//            System.out.println("新增失败!");
//            e.printStackTrace();
//        }
//        return flag;
//    }

    @Override
    public Integer addType(String type) {
        return typesMapper.addType(type);
    }



    //    删除电影类型
    @Override
    public boolean deleteType(Integer type_id) {
        boolean flag=false;
        try{
            typesMapper.deleteById(type_id);
            flag=true;
        }catch(Exception e){
            System.out.println("删除失败!");
            e.printStackTrace();
        }
        return flag;
    }

}


