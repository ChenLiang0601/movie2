package com.movie2.service.impl;

import com.movie2.bean.CommentView;
import com.movie2.mapper.CommentViewMapper;
import com.movie2.mapper.CommentsMapper;
import com.movie2.service.CommentViewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
@Service
public class CommentViewServiceImpl extends ServiceImpl<CommentViewMapper, CommentView> implements CommentViewService {

    @Resource
    CommentViewMapper commentViewMapper;

    @Override
    public List<CommentView> findComment(String comment) {
        return commentViewMapper.findComment(comment);
    }

    @Override
    public List<CommentView> findAllComments() {
        return commentViewMapper.findAllComments();
    }
}
