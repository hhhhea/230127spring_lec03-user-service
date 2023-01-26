package com.example.lec03userservice.controllers.dtos;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String name;
    private String password;
    private String email;
}
