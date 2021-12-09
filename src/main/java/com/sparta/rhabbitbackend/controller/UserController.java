package com.sparta.rhabbitbackend.controller;

import com.sparta.rhabbitbackend.dto.SignupRequestDto;
import com.sparta.rhabbitbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/user/signup")
    public void registerUser(@RequestBody SignupRequestDto requestDto){
        userService.registerUser(requestDto);
    }
}
