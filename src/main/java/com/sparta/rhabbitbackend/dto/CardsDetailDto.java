package com.sparta.rhabbitbackend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CardsDetailDto {
    private Long textId;
    private String text;
    private Boolean checked;
    private Boolean daily;

}
