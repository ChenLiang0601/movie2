package com.movie2.controller;


import com.movie2.bean.*;
import com.movie2.mapper.UserMapper;
import com.movie2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    @Resource
    MTypeService mTypeService;



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
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model) {
        if (userService.userLogin(username, password) != null) {

//            findTypeService.findUser(username);
            System.out.println(username);
            User user = userService.findOneUserByUsername(username);
            List<UserType> userTypes = userTypeService.findUserType(user.getUsername());
            System.out.println(userTypes);
            session.setAttribute("user",user);


            return "user/loginSuccess";
        }
        else
            return "user/userLogin";
    }

    @RequestMapping("/register2")
    public String register2() {
        return "user/egister";
    }

    @RequestMapping("/toUserInfo")
    public String toUserInfo(){
        return "user/userInformation";}

    @RequestMapping("/toUpdate")
    public String toUpdate(){
        return "user/updateuser";}
    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public String register (User user,@RequestParam(value = "utype") List<String> utype, Model model){


        List<FindType> findTypes = findTypeService.findUser(user.getUsername());
        if(!findTypes.isEmpty())
        {
            model.addAttribute("msg", "用户已经存在");
            return "user/register";
        }

        List<UserType> userTypes = new ArrayList<>();
        for(String str:utype){
            userTypes.add(new UserType(null,str,user.getUsername()));
        }
        userTypeService.addUType(userTypes);
        System.out.println(userTypes);
        userService.register(user);
        System.out.println(user);
        return "user/userLogin";}

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
    public String updateUser(User user,@RequestParam(value = "utype") List<String> utype){
        List<UserType> userTypes = new ArrayList<>();
        for(String str:utype){
            userTypes.add(new UserType(null,str,user.getUsername()));
        }
        userTypeService.updateUType(userTypes);
        userService.updateUser(user);
        System.out.println(user);
        return "user/userList";
    }
    /**
     * 根据用户名查看用户信息
     * 用于用户信息页
     */
    @RequestMapping("/findUser")
    public String findUser(Model model,HttpSession session ){
        User user = (User)session.getAttribute("user");
        List<UserType> userTypes = userTypeService.findUserType(user.getUsername());
//            System.out.println(userTypes);
        model.addAttribute("user",user);
        System.out.println(user);
        model.addAttribute("userTypes",userTypes);
        System.out.println(userTypes);
        return "user/userInformation";
    }

    /**
     * 查找所有用户
     * 用于用户管理页
     * @return
     */
//    @ResponseBody
    @RequestMapping("/findAll")
    public String findAllUser(Model model){
        userService.findAllUser();
        //控制台输出
        List<User> users = userService.findAllUser();
        model.addAttribute("allUser",users);
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

    @RequestMapping("/movieInfo")
    public String movieInfo(Integer movieId){
        mTypeService.movieinfo(movieId);
        MType mType = mTypeService.movieinfo(movieId);
        System.out.println(mType);
        return "/movie/movieInformation";
    }
}

