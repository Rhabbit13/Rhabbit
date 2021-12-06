package com.sparta.rhabbitbackend.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column
    private String userId;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String name;
}
