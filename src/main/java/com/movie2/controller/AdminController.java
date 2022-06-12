package com.movie2.controller;


import com.movie2.bean.Comments;
import com.movie2.bean.Types;
import com.movie2.service.AdminService;
import com.movie2.service.CommentsService;
import com.movie2.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private TypesService typesService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private CommentsService commentsService;

    /*
    * 管理员登录
    * */
    @RequestMapping("/login")
    public String adminLogin(@RequestParam("adminUsername") String adminUsername, @RequestParam("adminPwd") String adminPwd) {
        if (adminService.adminLogin(adminUsername, adminPwd) != null)
            return "user/loginSuccess";
        else
            return "user/userLogin";
    }

    @RequestMapping("/types")
    public String index() {
        return "type/typeList";
    }

    /**
     * 添加电影类型
     * @param type
     * @return
     */
    @RequestMapping("/addType")
    public String addType(String type){
        typesService.addType(type);
        return "type/typeList";
    }
    /**
     * 删除电影类型
     */
    @RequestMapping("deleteType")
    public String deleteType(Integer type_id){
        typesService.deleteType(type_id);
        return "type/typeList";
    }
    /*
    * 查找电影类型
    * */
    @RequestMapping("/findType")
    public String findType(String type){
        typesService.findType(type);
        List<Types> types = typesService.findType(type);
        System.out.println(types);
        return "type/typeList";
    }
    /*
    * 查找所有类型
    * 电影类型管理
    * */
    @RequestMapping("/findAllTypes")
    public String findAllTypes(){
        typesService.findAllTypes();
        List<Types> types = typesService.findAllTypes();
        System.out.println(types);
        return "type/typeList";
    }
    @RequestMapping("/comments")
    public String index1() {
        return "comment/commentList";
    }

    @RequestMapping("/findAllComments")
    public String findAllComments(){
        commentsService.findAllComments();
        List<Comments> comments = commentsService.findAllComments();
        System.out.println(comments);
        return "comment/commentList";
    }
    /**
     * 评论管理
     * @param comment
     * @return
     */
    @RequestMapping("/findComment")
    public String findComment(String comment){
        commentsService.findComment(comment);
        List<Comments> comments= commentsService.findComment(comment);
        System.out.println(comments);
        return "comment/commentList";
    }


}

