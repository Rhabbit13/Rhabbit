package com.sparta.rhabbitbackend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CardsResponseDto {     //할 일 불러오기
    private int rate;
    private List<CardsDetailDto> texts;
    private int date;
}
