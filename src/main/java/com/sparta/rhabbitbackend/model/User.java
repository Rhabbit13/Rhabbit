package com.sparta.rhabbitbackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    // 사용자 ID == email(username vs userid)
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    public User(String username,String nickname ,String enPassword) {
        this.username = username;
        this.nickname = nickname;
        this.password = enPassword;
    }
}
