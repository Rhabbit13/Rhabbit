package com.sparta.rhabbitbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String email;
    private String nickname;
    private String password;
}
