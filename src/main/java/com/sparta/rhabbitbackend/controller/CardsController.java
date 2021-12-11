package com.sparta.rhabbitbackend.controller;

import com.sparta.rhabbitbackend.dto.CardsDetailDto;
import com.sparta.rhabbitbackend.dto.CardsRequestDto;
import com.sparta.rhabbitbackend.dto.CardsResponseDto;
import com.sparta.rhabbitbackend.security.UserDetailsImpl;
import com.sparta.rhabbitbackend.service.CardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsController {

    private final CardsService cardsService;

    //메인화면
    @GetMapping("/api/cards")
    public List<CardsResponseDto> viewAllCards(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ){
        return cardsService.viewAllCards(userDetails.getUser());
    }

    //디테일 화면
    @GetMapping("/api/{cardId}/detail")
    public CardsResponseDto viewCards(
            @PathVariable Long cardId,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ){
        return cardsService.viewCards(userDetails.getUser(), cardId);
    }

    //카드 디테일에 리스트 추가하기
    @PostMapping("/api/{cardId}/detail/todolist")
    public CardsDetailDto createList(
            @PathVariable Long cardId,
            @RequestBody CardsRequestDto cardsRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ){
        return cardsService.createDetail(cardId, cardsRequestDto, userDetails.getUser());
    }

    //디테일 수정(체크박스, 데일리, 텍스트)
    @PutMapping("/api/{cardId}/detail/update")
    public void updateList(
            @PathVariable Long cardId,
            @RequestBody CardsDetailDto cardsDetailDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ){
        cardsService.updateDetail(cardId, cardsDetailDto, userDetails.getUser());
    }

    //리스트 삭제
    @DeleteMapping("/api/{cardId}/detail/delete/{textId}")
    public void deleteList(@PathVariable Long textId, @PathVariable Long cardId) {
        cardsService.deleteDetail(textId, cardId);
    }

    //포스트 한개 추가
    //cardId == 가장 최근에 생성된 카드아이디
    @PostMapping("/api/cards/{cardId}")
    public CardsResponseDto createCard(@PathVariable Long cardId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return cardsService.createCard(cardId, userDetails.getUser());
    }
}

