package com.example.handler;

import lombok.Data;

import java.util.Date;

@Data
public class Exception<E> {
    private String path;
    private Date createTime;
    private String hostName;
    private E message;
}
