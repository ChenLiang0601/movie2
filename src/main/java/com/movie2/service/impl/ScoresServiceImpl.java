package com.movie2.service.impl;

import com.movie2.bean.Scores;
import com.movie2.mapper.ScoresMapper;
import com.movie2.service.ScoresService;
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
public class ScoresServiceImpl extends ServiceImpl<ScoresMapper, Scores> implements ScoresService {

    @Resource
    ScoresMapper scoresMapper;
    @Override
    public boolean deleteScore(Integer user_id) {
        boolean flag=false;
        try{
//            commentsMapper.deleteById(user_id);
            scoresMapper.deleteById(user_id);
//            userMapper.deleteById(user_id);
            flag=true;
        }catch(Exception e){
            System.out.println("删除失败 score service!");
            e.printStackTrace();
        }
        return flag;
    }
}
