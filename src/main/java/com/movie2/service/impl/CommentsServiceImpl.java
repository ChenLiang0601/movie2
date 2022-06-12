package com.movie2.service.impl;

import com.movie2.bean.Comments;
import com.movie2.mapper.CommentsMapper;
import com.movie2.service.CommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

    @Resource
    CommentsMapper commentsMapper;
    @Override
    public boolean deleteComment(Integer user_id) {
        boolean flag=false;
        try{
            commentsMapper.deleteById(user_id);
            flag=true;
        }catch(Exception e){
            System.out.println("删除失败comment!");
            e.printStackTrace();
        }
        return flag;
    }

    /*
    * 用户发表评论
    * */
    @Override
    public boolean addComment(Comments comments){
        comments.setTime(new Date());
    boolean flag=false;
        try{

        commentsMapper.insert(comments);
        flag=true;
    }catch(Exception e){
        System.out.println("发表评论失败!");
        e.printStackTrace();
    }
        return flag;
}
    /*
    * 管理员查找评论
    * */
    @Override
    public List<Comments> findComment(String comment) {
        return commentsMapper.findComment(comment);
    }
    /*
    * 后台评论管理
    * */
    @Override
    public List<Comments> findAllComments() {
        return commentsMapper.findAllComments();
    }
}
