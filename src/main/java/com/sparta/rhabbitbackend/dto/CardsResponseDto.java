package com.sparta.rhabbitbackend.dto;

import com.sparta.rhabbitbackend.model.Cards;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CardsResponseDto {     //할 일 불러오기
    private Cards cards;
    private Long userId;
    private String nickname;
    private List<CardsDetailDto> cardsDetailDtos;
}
//유저아이디, 닉네임, 날짜