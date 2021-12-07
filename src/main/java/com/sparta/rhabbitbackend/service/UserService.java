package com.sparta.rhabbitbackend.service;

import com.sparta.rhabbitbackend.dto.SignupRequestDto;
import com.sparta.rhabbitbackend.model.User;
import com.sparta.rhabbitbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    //회원가입
    public void registerUser(SignupRequestDto requestDto) {
        //username == email
        String username = requestDto.getEmail();
        String nickname = requestDto.getNickname();

        //패스워드 암호화
        String enPassword = passwordEncoder.encode(requestDto.getPassword());

        // 회원 이메일 중복 확인
        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("중복된 이메일입니다.");
        }

        User user = new User(username, nickname, enPassword);
        userRepository.save(user);
    }
}
