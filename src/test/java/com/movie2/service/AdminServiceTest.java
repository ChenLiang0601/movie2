package com.movie2.service;

import com.movie2.vo.dataVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Test
    void finddata(){
        dataVo dataVo = adminService.finddata(1,1);
        int i=0;
    }
}