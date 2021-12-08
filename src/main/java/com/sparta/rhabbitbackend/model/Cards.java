package com.sparta.rhabbitbackend.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long userId;

    @Column
    private int rate;           //달성도

    @OneToMany(cascade = CascadeType.ALL)
    private List<CardsDetail> cardDetails;

    @Column
    private String date;           //월 / 일 / 시간 / 분

    @Builder
    public Cards(Long userId, List<CardsDetail> cardDetails, String date, int rate){
        this.cardDetails = cardDetails;
        this.date = date;
        this.rate = rate;
        this.userId = userId;
    }
}
