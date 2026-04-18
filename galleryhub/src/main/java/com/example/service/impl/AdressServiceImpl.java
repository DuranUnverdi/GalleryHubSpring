package com.example.service.impl;

import com.example.exception.BaseException;
import com.example.exception.ErrorMessage;
import com.example.exception.MessageType;
import com.example.service.IAdressService;
import org.springframework.stereotype.Service;

@Service
public class AdressServiceImpl implements IAdressService {

    public void checkRecord() {
        throw new BaseException(
                new ErrorMessage(
                        MessageType.NO_RECORD_EXIST,
                        "Adres kaydı bulunamadı"
                )
        );
    }
}