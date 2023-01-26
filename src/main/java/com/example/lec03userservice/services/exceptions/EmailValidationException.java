package com.example.lec03userservice.services.exceptions;

public class EmailValidationException extends CommonException {
    public EmailValidationException(String code, String message){
        super(code, message);
    }

}
