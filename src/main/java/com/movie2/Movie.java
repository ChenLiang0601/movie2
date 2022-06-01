package com.movie2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.movie2.mapper")
@SpringBootApplication
public class Movie {

    public static void main(String[] args) {
        SpringApplication.run(Movie.class, args);
    }

}
