package com.movie2.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.movie2.bean.*;
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
    private CommentViewService commentViewService;
    @Autowired
    private UserService userService;
    @Autowired
    private MoviesService moviesService;

    /*
    * 管理员登录
    * */
    @RequestMapping("")
    public String login()
    {
        return "admin/adminLogin";
    }
    @RequestMapping("/login")
    public String adminLogin(@RequestParam("adminUsername") String adminUsername, @RequestParam("adminPwd") String adminPwd) {
        System.out.println(adminUsername+adminPwd);
        if (adminService.adminLogin(adminUsername, adminPwd) != null)
            return "admin/adminHome";
        else
            return "admin/adminLogin";
    }
    /**
     * 管理员主界面
     * @return
     */
    @RequestMapping("/adminHome")
    public String adminHome() {
        return "admin/adminHome";
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
    /**
     * 电影类型管理模块
     */
    /**
     * 显示所有电影类型
     * @return
     */
    @ResponseBody
    @RequestMapping("typesList")
    public dataVo TypesList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        return adminService.findTypes(pageNum, pageSize);
    }
    @RequestMapping(value ="adminTypes" ,method = RequestMethod.GET)
    public String  findAllTypes(Model model)
    {
        List<Types> types = typesService.findAllTypes();
        System.out.println(types);
        model.addAttribute("types", types);
        return "admin/adminTypes";
    }
    /**
     * 删除电影类型
     */
    @ResponseBody
    @RequestMapping(value = "deleteTypes",method = RequestMethod.DELETE)
    public boolean deleteTypes(@RequestParam("typeId") Integer typeId)
    {
        return  typesService.deleteType(typeId);
    }
    /**
     * 添加电影类型
     */
    @RequestMapping(value = "addTypes")
    public String addTypes(@ModelAttribute("Movies") Types types)
    {
        return "admin/addTypes";
    }
    @RequestMapping(value = "toAddTypes")
    public String toAddTypes(@ModelAttribute("Types") String type)
    {
        System.out.println(type);
        typesService.addType(type);
        return "admin/addTypes";
    }
    /**
     * 编辑电影类型
     */
    @RequestMapping(value = "editTypes")
    public String editTypes(Model model,@RequestParam("typeId") Integer typeId)
    {
        System.out.println(typeId);
        Types types=typesService.getById(typeId);
        model.addAttribute("types", types);
        return "admin/editTypes";
    }
    @RequestMapping(value = "toEditTypes")
    public String toEditMovie(@ModelAttribute("Types") Types types)
    {
        System.out.println(types);
        typesService.updateTypes(types);
        return "redirect:/admin/editTypes?typeId="+types.getTypeId();
    }
    /**
     * 电影类型模糊查询
     * @return
     */
    @ResponseBody
    @RequestMapping("searchTypes")
    public dataVo searchTypes(@RequestParam String type){
        System.out.println(type);
        return adminService.searchTypes(1,10,type);
    }
    /**
     * 用户管理模块
     */
    /**
     * 显示所有用户
     */
    @ResponseBody
    @RequestMapping("userList")
    public dataVo userList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        return adminService.findUser(pageNum,pageSize);
    }
    @RequestMapping(value ="adminUser" ,method = RequestMethod.GET)
    public String  findALLUser(Model model)
    {
        List<User> users = userService.findAllUser();
        model.addAttribute("users", users);
        return "admin/adminUser";
    }
    /**
     * 删除用户
     */
    @ResponseBody
    @RequestMapping(value = "deleteUser",method = RequestMethod.DELETE)
    public boolean deleteUser(@RequestParam("userId") Integer userId)
    {
        return  userService.deleteUser(userId);
    }
    /**
     * 添加用户
     */
    @RequestMapping(value = "addUser")
    public String addUser(@ModelAttribute("User") User user)
    {
        return "admin/addUser";
    }
    @RequestMapping(value = "toAddUser")
    public String toAddUser(@ModelAttribute("User") User user)
    {
        System.out.println(user);
        userService.register(user);
        return "admin/addUser";
    }
    /**
     * 编辑用户
     */
    @RequestMapping(value = "editUser")
    public String editUser(Model model,@RequestParam("userId") Integer userId)
    {
        System.out.println(userId);
        User user = userService.getById(userId);
        model.addAttribute("user", user);
        return "admin/editUser";
    }
    @RequestMapping(value = "toEditUser")
    public String toEditUser(@ModelAttribute("User") User user)
    {
        System.out.println(user);
        userService.updateUser(user);
        return "redirect:/admin/editUser?userId="+user.getUserId();
    }
    /**
     * 用户名字模糊查询
     * @return
     */
    @ResponseBody
    @RequestMapping("searchUser")
    public dataVo searchUser(@RequestParam("username") String username){
        System.out.println(username);
        return adminService.searchUser(1,10,username);
    }


    /**
     * 评论管理模块
     */
    /**
     * 显示所有评论
     */
    @ResponseBody
    @RequestMapping("commentsList")
    public dataVo commentsList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        return adminService.findComments(pageNum,pageSize);
    }
    @RequestMapping(value ="adminComments" ,method = RequestMethod.GET)
    public String  adminComments(Model model)
    {
        List<CommentView> commentViews = commentViewService.findAllComments();
        System.out.println(commentViews);
        model.addAttribute("commentViews", commentViews);
        return "admin/adminComments";
    }
    /**
     * 删除评论
     */
    @ResponseBody
    @RequestMapping(value = "deleteComments",method = RequestMethod.DELETE)
    public boolean deleteComments(@RequestParam("comment") String comment)
    {
        return  commentsService.delete(comment);
    }
    /**
     * 电影评论模糊查询
     * @return
     */
    @ResponseBody
    @RequestMapping("searchComments")
    public dataVo searchComments(@RequestParam("comment") String comment){
        System.out.println(comment);
        return adminService.searComments(1,10,comment);
//        return adminService.searchUser(1,10,username);
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
        String finalFilePath =filePath+file.getOriginalFilename().trim();
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

