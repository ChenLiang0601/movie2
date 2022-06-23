package com.movie2.mapper;

import com.movie2.bean.CommentView;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.movie2.bean.Comments;

import java.util.List;

/**
 * <p>
 * VIEW Mapper 接口
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public interface CommentViewMapper extends BaseMapper<CommentView> {
    /*
     *
     * 评论管理：查找评论
     * */
    List<CommentView> findComment(String comment);
    /*
     * 评论管理主页：查找所有评论
     * */
    List<CommentView> findAllComments();
}
