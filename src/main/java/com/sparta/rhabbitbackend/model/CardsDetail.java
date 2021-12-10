package com.sparta.rhabbitbackend.model;

import com.sparta.rhabbitbackend.dto.CardsDetailDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.smartcardio.Card;

@Getter
@NoArgsConstructor
@Entity
public class CardsDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //textId

    //카드 한 개에 텍스트 여러개
    @Column
    private Long cardsId;

    @Column
    private String text;

    @Column
    private Boolean checked;

    @Column
    private Boolean daily;

    @Builder
    public CardsDetail(Long cardsId, String text, Boolean checked, Boolean daily){
        this.cardsId = cardsId;
        this.text = text;
        this.checked = checked;
        this.daily = daily;
    }

    public void update(CardsDetailDto cardsDetailDto) {
        this.text = cardsDetailDto.getText();
        this.checked = cardsDetailDto.getChecked();
        this.daily = cardsDetailDto.getDaily();
    }
}
