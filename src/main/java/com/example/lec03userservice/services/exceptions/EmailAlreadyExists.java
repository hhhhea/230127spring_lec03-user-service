package com.example.lec03userservice.services.exceptions;

public class EmailAlreadyExists extends CommonException{
    public EmailAlreadyExists(String code, String message){
        super(code,message);
    }
}
