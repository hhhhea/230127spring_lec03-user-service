package com.example.lec03userservice.services.exceptions;

public class UserNotExist extends CommonException{
    public UserNotExist(String code, String message){
        super(code, message);
    }
}
