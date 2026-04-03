package com.example.exception;

import lombok.Getter;

@Getter
public enum MessageType {
    NO_RECORD_EXIST("1004","Kayıt bulunamadı"),
    GENERAL_EXCEPTION("9999","Beklenmedik bir hata oluştu"),
    USERNAME_NOT_FOUND("1001","Kullanıcı adı bulunamadı");
    private final String code;
    private final String message;
     MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

     public String getCode() {
         return code;
     }
}
