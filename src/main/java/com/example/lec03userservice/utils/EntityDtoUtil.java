package com.example.lec03userservice.utils;

import com.example.lec03userservice.controllers.dtos.CreateUserRequest;
import com.example.lec03userservice.controllers.dtos.ErrorResponse;
import com.example.lec03userservice.controllers.dtos.UpdateUserRequest;
import com.example.lec03userservice.controllers.dtos.UserResponse;
import com.example.lec03userservice.services.exceptions.CommonException;
import com.example.lec03userservice.stores.entities.User;

public class EntityDtoUtil {
    public static UserResponse toUserDto(User user) {
        var userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }
    public static User toEntity(CreateUserRequest createUserRequest) {
        var user = new User();
        user.setName(createUserRequest.getName());
        user.setPassword(createUserRequest.getPassword());
        user.setEmail(createUserRequest.getEmail());
        user.setPasswordConfirm(createUserRequest.getPasswordConfirm());
        return user;
    }

    public static User toEntity(UpdateUserRequest updateUserRequest) {
        var user = new User();
        user.setName(updateUserRequest.getName());
        user.setEmail(updateUserRequest.getEmail());
        return user;
    }

    public static ErrorResponse toErrorDto(CommonException e) {
        return new ErrorResponse(e.getCode(), e.getMessage());
    }
}
