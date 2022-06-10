package com.movie2.controller;


import com.movie2.bean.Types;
import com.movie2.service.TypesService;
import com.movie2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
@Controller


public class TypesController {
    @Autowired
    private TypesService typesService;

    @RequestMapping("/types")
    public String index() {
        return "type/addType";
    }
//add
    @RequestMapping("/addType")
    public String addType(String type){
        typesService.addType(type);
        return "type/typeList";
    }
    //delete
    //find
}

