package com.example.lec03userservice.services.exceptions;

public class NameValidationException extends CommonException{
    public NameValidationException(String code, String message){
        super(code, message);
    }
}
