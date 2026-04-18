package com.example.controller;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RootEntity<T> {

    private Integer status;
    private T payload;
    private String errorMessage;

    // GETTERS
    public Integer getStatus() {
        return status;
    }

    public T getPayload() {
        return payload;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    // SETTERS
    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // SUCCESS RESPONSE
    public static <T> RootEntity<T> ok(T payload) {
        RootEntity<T> rootEntity = new RootEntity<>();
        rootEntity.setStatus(200);
        rootEntity.setPayload(payload);
        return rootEntity;
    }

    // ERROR RESPONSE
    public static <T> RootEntity<T> error(String errorMessage) {
        RootEntity<T> rootEntity = new RootEntity<>();
        rootEntity.setStatus(500);
        rootEntity.setErrorMessage(errorMessage);
        return rootEntity;
    }
}