package com.sparta.rhabbitbackend.dto;

import com.sparta.rhabbitbackend.model.Cards;
import com.sparta.rhabbitbackend.model.CardsDetail;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CardsResponseDto {     //할 일 불러오기
    private Long cardsId;
    private Long userId;
    private String nickname;
    private List<CardsDetailDto> texts;
    private String date;

    public CardsResponseDto(Cards cards){
        List<CardsDetailDto> cardsDetailDtos = new ArrayList<>();
        this.cardsId = cards.getId();
        this.userId = cards.getUser().getId();
        this.nickname = cards.getUser().getNickname();
        for (CardsDetail cardsDetail : cards.getCardDetails()){
            CardsDetailDto cardsDetailDto = CardsDetailDto.builder()
                    .textId(cardsDetail.getId())
                    .text(cardsDetail.getText())
                    .checked(cardsDetail.getChecked())
                    .daily(cardsDetail.getDaily())
                    .build();
            cardsDetailDtos.add(cardsDetailDto);
        }
        this.texts = cardsDetailDtos;
        this.date = cards.getDate();
    }
}



