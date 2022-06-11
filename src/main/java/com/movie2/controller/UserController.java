package com.movie2.controller;


import com.movie2.bean.FindType;
import com.movie2.bean.User;
import com.movie2.mapper.UserMapper;
import com.movie2.service.CommentsService;
import com.movie2.service.FindTypeService;
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
    @Resource
    private FindTypeService findTypeService;


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
    /**
    * 修改用户信息
    */
    @RequestMapping("/updateUser")
    public String updateUser(User user){
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
        FindType findType = findTypeService.findUser(username);
        System.out.println(findType);
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
}

