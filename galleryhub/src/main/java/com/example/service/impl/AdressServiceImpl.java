package com.example.service.impl;

import com.example.exception.BaseExcepciton;
import com.example.exception.ErrorMessage;
import com.example.exception.MessageType;
import com.example.service.IAdressService;
import org.springframework.stereotype.Service;

@Service
public class AdressServiceImpl implements IAdressService {
    public void BaseException(){
        throw new BaseExcepciton(new ErrorMessage(null, MessageType.NO_RECORD_EXIST));
    }
}
