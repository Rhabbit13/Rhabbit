package com.sparta.rhabbitbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardsRequestDto {      //할일 추가하기(모달창)
    private String text;
    private Boolean checked;
    private Boolean daily;
}
