package com.example.handler;

import lombok.Data;

@Data
public class ApiError<E> {
    private Exception<E> exception;
    private Integer Status;


}
