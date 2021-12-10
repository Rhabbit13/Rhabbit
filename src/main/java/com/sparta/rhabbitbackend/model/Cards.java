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

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<CardsDetail> cardDetails;

    @Column
    private String date;           //월 / 일 / 시간 / 분

    @Builder
    public Cards(User user, List<CardsDetail> cardDetails, String date){
        this.cardDetails = cardDetails;
        this.date = date;
        this.user = user;
    }

    public void updateCard(List<CardsDetail> cardDetails){
        this.cardDetails = cardDetails;
    }
}
