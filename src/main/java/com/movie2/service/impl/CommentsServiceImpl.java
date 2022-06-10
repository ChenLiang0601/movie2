package com.movie2.service.impl;

import com.movie2.bean.Comments;
import com.movie2.mapper.CommentsMapper;
import com.movie2.service.CommentsService;
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
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

    @Resource
    CommentsMapper commentsMapper;
    @Override
    public boolean deleteComment(Integer user_id) {
        boolean flag=false;
        try{
            commentsMapper.deleteById(user_id);
//            scoresMapper.deleteById(user_id);
//            userMapper.deleteById(user_id);
            flag=true;
        }catch(Exception e){
            System.out.println("删除失败comment!");
            e.printStackTrace();
        }
        return flag;
    }
}
