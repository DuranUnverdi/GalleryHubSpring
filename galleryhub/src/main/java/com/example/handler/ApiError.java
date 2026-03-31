package com.example.handler;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

public class ApiError<E> {
    private Exception<E> exception;
    private Integer status;

    // Boş Constructor (NoArgsConstructor)
    public ApiError() {
    }

    // Dolu Constructor (AllArgsConstructor)
    public ApiError(Exception<E> exception, Integer status) {
        this.exception = exception;
        this.status = status;
    }

    // Exception için Getter
    public Exception<E> getException() {
        return exception;
    }

    // Exception için Setter
    public void setException(Exception<E> exception) {
        this.exception = exception;
    }

    // Status için Getter
    public Integer getStatus() {
        return status;
    }

    // Status için Setter
    public void setStatus(Integer status) {
        this.status = status;
    }
}