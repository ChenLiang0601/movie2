package com.movie2.controller;


import com.movie2.bean.User;
import com.movie2.service.CommentsService;
import com.movie2.service.ScoresService;
import com.movie2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private CommentsService commentsService;
    @Resource
    private ScoresService scoresService;


    @RequestMapping("/")
    public String index() {
        return "user/userLogin";
    }
//登录
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (userService.userLogin(username, password) != null)
            return "user/loginSuccess";
        else
            return "user/userLogin";
    }
    @RequestMapping("/register2")
    public String register2() {
        return "user/register";
    }
//注册
    @RequestMapping("/register")
    public String register(User user){
        userService.register(user);
        return "user/userLogin";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(Integer user_id){
        commentsService.deleteComment(user_id);
        scoresService.deleteScore(user_id);
        userService.deleteUser(user_id);
        //返回userList页面
        return "删除成功";
    }
    //update
//    @GetMapping("userList")
//    public String userList(){
//        ;
//    }
}

