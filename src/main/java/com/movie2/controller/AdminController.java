package com.movie2.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.movie2.bean.Comments;
import com.movie2.bean.Movies;
import com.movie2.bean.Types;
import com.movie2.bean.User;
import com.movie2.mapper.TypesMapper;
import com.movie2.service.*;
import com.movie2.vo.adminMovieVo;
import com.movie2.vo.dataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.model.IModel;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @Resource
    @Autowired
    private AdminService adminService;
    @Autowired
    private CommentsService commentsService;
    @Autowired
    private UserService userService;
    @Autowired
    private MoviesService moviesService;

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

    /**
     * 通过用户名模糊查找用户
     * 用于用户管理
     * @param username
     * @return
     */
    @RequestMapping("findUser")
    public String findUserByUsername(String username){
        userService.findUserByUsername(username);
        List<User> users = userService.findUserByUsername(username);
        System.out.println(users);
        return "user/userList";
    }

    /**
     * 电影管理模块
     */
    /**
     * 显示所有电影
     * @return
     */
    @ResponseBody
    @RequestMapping("movieList")
    public dataVo List(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        return adminService.finddata(pageNum, pageSize);
    }

    @RequestMapping(value ="adminMovie" ,method = RequestMethod.GET)
    public String  findAllMovies(Model model)
    {
        List<Movies> movies = moviesService.findAllMovies();
        model.addAttribute("movies", movies);
        return "admin/adminMovie";
    }

    /**
     * 删除电影
     */
    @ResponseBody
    @RequestMapping(value = "deleteMovie",method = RequestMethod.DELETE)
    public boolean deleteMovie(@RequestParam("movieId") Integer movieId)
    {
        return  moviesService.deleteMovie(movieId);
    }
    /**
     * 添加电影
     */
    @RequestMapping(value = "addMovie")
    public String addMovie(@ModelAttribute("Movies") Movies movies)
    {
        return "admin/addMovie";
    }
    @RequestMapping(value = "toAddMovie")
    public String add(@ModelAttribute("Movies") Movies movies)
    {
        System.out.println(movies);
        moviesService.addMovie(movies);
        return "admin/addMovie";
    }
    /**
     * 编辑电影
     */
    @RequestMapping(value = "editMovie")
    public String editMovie(Model model,@RequestParam("movieId") Integer movieId)
    {
        System.out.println(movieId);
        Movies movies = moviesService.findById(movieId);
        model.addAttribute("movies", movies);
        return "admin/eidtMovie";
    }
//    @ResponseBody
    @RequestMapping(value = "toEditMovie")
    public String toEditMovie(@ModelAttribute("Movies") Movies movies)
    {
        System.out.println(movies);
        moviesService.updateMovie(movies);
        return "redirect:/admin/editMovie?movieId="+movies.getMovieId();
    }
    /**
     * 电影名字模糊查询
     * @return
     */
    @ResponseBody
    @RequestMapping("searchMovie")
    public dataVo searchMovie(@RequestParam String name){
        System.out.println(name);
        return adminService.searchMovie(1, 10,name);
    }
    //图片上传
    @ResponseBody
    @RequestMapping("/uploadFile")
    public JSON uploadFile(MultipartFile file, HttpServletRequest request) {
        JSONObject json = new JSONObject();
        //路径
        String filePath = System.getProperty("user.dir") + "/src/main/resources/static/image/";//上传到这个文件夹
        File file1 = new File(filePath);
        //如果没有的话创建一个
        if (!file1.exists()) {
            file1.mkdirs();
        }
        //路径+文件名
        //文件名：file.getOriginalFilename()
        String finalFilePath =file.getOriginalFilename().trim();
        File desFile = new File(finalFilePath);
        if (desFile.exists()) {
            desFile.delete();
        }
        try {
            file.transferTo(desFile);
            json.put("code", 0);
            //将文件名放在msg中，前台提交表单时需要用到
            json.put("msg", file.getOriginalFilename().trim());
            JSONObject json2 = new JSONObject();
            json2.put("src", finalFilePath);
            json2.put("title", "");
            json.put("Data", json2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            json.put("code", 1);
        }
        System.out.println(json);
        return json;
    }

}

