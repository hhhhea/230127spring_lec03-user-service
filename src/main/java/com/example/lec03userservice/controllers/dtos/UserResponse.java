package com.example.lec03userservice.controllers.dtos;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String email;
}
