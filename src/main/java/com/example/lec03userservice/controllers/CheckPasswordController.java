package com.example.lec03userservice.controllers;

import com.example.lec03userservice.controllers.dtos.ErrorResponse;
import com.example.lec03userservice.services.UserService;
import com.example.lec03userservice.services.exceptions.CommonException;
import com.example.lec03userservice.services.exceptions.PasswordNotMatch;
import com.example.lec03userservice.utils.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("check-password")
public class CheckPasswordController {
    private final UserService userService;

    @PostMapping("{email}")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public boolean checkPassword(@PathVariable String email, @RequestBody String password) {
        return userService.checkPassword(email, password);


    }

    @ExceptionHandler(PasswordNotMatch.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Mono<ErrorResponse> handlePasswordNotFoundException(CommonException e){
        return Mono.just(EntityDtoUtil.toErrorDto(e));
    }


}
