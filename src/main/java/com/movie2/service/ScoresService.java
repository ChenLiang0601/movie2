package com.movie2.service;

import com.movie2.bean.Scores;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public interface ScoresService extends IService<Scores> {
    //删除评分
    boolean deleteScore(Integer user_id);
    /*
    * 添加评分
    * */
    boolean addScore(Scores scores);

//    /**
//     * 电影评分
//     */
//    Scores findScore();

}
