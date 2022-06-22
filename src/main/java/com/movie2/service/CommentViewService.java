package com.movie2.service;

import com.movie2.bean.CommentView;
import com.baomidou.mybatisplus.extension.service.IService;
import com.movie2.bean.Comments;

import java.util.List;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public interface CommentViewService extends IService<CommentView> {
    /*
     * 查找评论
     * */
    List<CommentView> findComment(String comment);

    /*
     * 查找所有评论
     * */
    List<CommentView> findAllComments();

}
