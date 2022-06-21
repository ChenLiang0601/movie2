package com.movie2.vo;

import lombok.Data;

import java.util.List;

@Data
public class dataVo<T> {
    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;
}
