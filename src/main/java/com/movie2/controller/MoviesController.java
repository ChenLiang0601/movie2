package com.movie2.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.movie2.bean.Movies;
import com.movie2.bean.User;
import com.movie2.service.MoviesService;
import com.movie2.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/")
public class MoviesController {
    @Resource
    private MoviesService moviesService;

    /**
     * @return
     */
    @GetMapping(path ={"index","/"})
    public String getIndex(HttpSession session, Model model){
        User user = (User)session.getAttribute("user");
        Movies movies =(Movies)session.getAttribute("results");
        model.addAttribute("results",movies);
        model.addAttribute("user",user);
        return "movie/index";
    }

    /**
     * 电影根据名字模糊查找
     * @param name
     * @return
     */
    @RequestMapping(value ="test" ,method = RequestMethod.GET)
    public List<Movies> findByName(@RequestParam("name") String name){

        return moviesService.findMovie(name);
    }

    /**
     * 显示所有电影
     * 主页
     * @return
     */
//    @ResponseBody
    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public String findAllMovies(Model model, HttpSession session)
    {
         List<Movies> movies = moviesService.findAllMovies();
//         session.setAttribute("movies",movies);
         model.addAttribute("allMovie",movies);
//         model.addAttribute("Movies",movies);
        System.out.println(model);
         return "movie/home";
    }
    /**
     * 最热电影
     */
    @RequestMapping(value = "/test3",method = RequestMethod.GET)
    public String findByHeat(Model model)
    {
        List<Movies> movies =moviesService.findByHeat();
        model.addAttribute("heat",movies);
        System.out.println(model);
        return "movie/hot";
    }

    /**
     * 最新电影
     */
    @RequestMapping(value = "/test4",method = RequestMethod.GET)
    public String newsestMovie(Model model){
        List<Movies> movies = moviesService.findBytime();
        model.addAttribute("newest",movies);
        System.out.println(model);
        return "movie/new";}

    @RequestMapping(value = "/test5",method = RequestMethod.GET)
    public String findAllMovie(Model model, HttpSession session)
    {
        List<Movies> movies = moviesService.findAllMovies();
        session.setAttribute("movies",movies);
        model.addAttribute("allMovie",movies);
//         model.addAttribute("Movies",movies);
        System.out.println(model);
        return "movie/home";
    }

    /**
     * 添加电影
     */
//    @RequestMapping(value = "test5",method = RequestMethod.POST)
//    public boolean addMovie(Movies movies)
//    {
//        return moviesService.addMovie(movies);
//    }
}
