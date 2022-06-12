package com.movie2.mapper;

import com.movie2.bean.Comments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public interface CommentsMapper extends BaseMapper<Comments> {
    /*
    *
    * 评论管理：查找评论
    * */
    List<Comments> findComment(String comment);
    /*
    * 评论管理主页：查找所有评论
    * */
    List<Comments> findAllComments();
}
