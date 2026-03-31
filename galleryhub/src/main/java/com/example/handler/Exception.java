package com.example.handler;

import java.util.Date;

public class Exception<E> {
    private String path;
    private Date createTime;
    private String hostName;
    private E message;

    // Boş Constructor
    public Exception() {
    }

    // Parametreli Constructor
    public Exception(String path, Date createTime, String hostName, E message) {
        this.path = path;
        this.createTime = createTime;
        this.hostName = hostName;
        this.message = message;
    }

    // Path Getter & Setter
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    // CreateTime Getter & Setter
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    // HostName Getter & Setter
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    // Message (Generic E tipi) Getter & Setter
    public E getMessage() {
        return message;
    }

    public void setMessage(E message) {
        this.message = message;
    }
}