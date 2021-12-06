package com.sparta.rhabbitbackend.model;

import javax.persistence.*;
import java.util.List;

public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int rate;

    @OneToMany
    private List<CardsDetail> cardDetails;

    @Column
    private int date;
}
