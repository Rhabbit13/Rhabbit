package com.sparta.rhabbitbackend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CardsRequestDto {      //할일 추가하기(모달창)
    private String text;
    private Boolean checked;
    private Boolean daily;
}
