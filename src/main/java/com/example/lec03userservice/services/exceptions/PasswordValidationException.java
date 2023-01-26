package com.example.lec03userservice.services.exceptions;

public class PasswordValidationException extends CommonException{
    public PasswordValidationException(String code, String message){
        super(code, message);
    }
}
