package com.movie2.service;

import com.movie2.bean.Comments;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public interface CommentsService extends IService<Comments> {
    //删除评论
    boolean deleteComment(Integer user_id);
    /*
    * 添加评论
    * */
    boolean addComment(Comments comments);
    /*
    * 查找评论
    * */
    List<Comments> findComment(String comment);

    /*
    * 查找所有评论
    * */
    List<Comments> findAllComments();
}
