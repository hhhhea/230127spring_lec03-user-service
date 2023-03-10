package com.example.lec03userservice.controllers.dtos;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String name;
    private String password;
    private String passwordConfirm;
    private String email;

    public boolean isPasswordMatched(){
        return password != null && password.equals(passwordConfirm);
    }
}
