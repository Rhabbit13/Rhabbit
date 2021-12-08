package com.sparta.rhabbitbackend.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class CardsDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String text;

    @Column
    private Long cardsId;

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
}
