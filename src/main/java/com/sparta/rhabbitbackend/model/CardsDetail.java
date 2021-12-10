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
    @ManyToOne
    @JoinColumn
    private Cards cards;

    @ManyToOne
    @JoinColumn
    private User user;

    @Column
    private String text;

    @Column
    private Boolean checked;

    @Column
    private Boolean daily;

    @Builder
    public CardsDetail(Cards cards, User user, String text, Boolean checked, Boolean daily){
        this.cards = cards;
        this.user = user;
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