package com.movie2.controller;


import com.movie2.bean.*;
import com.movie2.mapper.UserMapper;
import com.movie2.service.*;
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
    @Resource
    private FindTypeService findTypeService;
    @Resource
    UserTypeService userTypeService;



    @RequestMapping("/")
    public String index() {
        return "user/userLogin";
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
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

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public String register(User user, UserType userType){
        userTypeService.addUType(userType);
        userService.register(user);
        return "user/userLogin";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(Integer user_id,String username){
        userTypeService.deleteUType(username);
        commentsService.deleteComment(user_id);
        scoresService.deleteScore(user_id);
        userService.deleteUser(user_id);
        //返回userList页面
        return "user/userList";
    }
    /**
    * 修改用户信息
    */
    @RequestMapping("/updateUser")
    public String updateUser(User user,UserType userType){
        userTypeService.updateUType(userType);
        userService.updateUser(user);
        System.out.println(user);
        return "user/userList";
    }
    /**
     * 根据用户名查看用户信息
     * 用于用户信息页
     */
    @RequestMapping("/findUser")
    public String findUser(String username){
        findTypeService.findUser(username);
        List<FindType> findTypes = findTypeService.findUser(username);
        System.out.println(findTypes);
        return "user/userInformation";
    }

    /**
     * 查找所有用户
     * 用于用户管理页
     * @return
     */
    @RequestMapping("/findAll")
    public String findAllUser(){
        userService.findAllUser();
        //控制台输出
        List<User> users = userService.findAllUser();
        System.out.println(users);
        return "user/userList";
    }
    /*
    * 发表评论
    * */
    @RequestMapping("/addComment")
    public String addComment(Comments comments){
        commentsService.addComment(comments);
        System.out.println(comments);
        return "/movie/movieInformation";
    }

    /**
     * 用户评分
     * @param scores
     * @return
     */
    @RequestMapping("/addScore")
    public String addScore(Scores scores){
        scoresService.addScore(scores);
        System.out.println(scores);
        return "/movie/movieInformation";
    }
}

