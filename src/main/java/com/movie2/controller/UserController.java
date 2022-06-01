package com.movie2.controller;


import com.movie2.bean.User;
import com.movie2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "user/userLogin";
    }

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

    @RequestMapping("/register")
//    public String register(@RequestParam("username") String username, @RequestParam("password") String password,
//                           @RequestParam("age") Integer age,@RequestParam("sex") String sex,@RequestParam("phonenumber") String phonenymber,
//                           @RequestParam("typeid") Integer typeid){
//        userService.register(new User(username,password,age,sex,phonenymber,typeid));
//        return "user/userLogin";



    public String register(User user){
//        User user1 = new User();
//        user.setPhonenumber(Integer.valueOf(user.getPhonenumber()));
        userService.register(user);

        return "user/userLogin";
    }
}

