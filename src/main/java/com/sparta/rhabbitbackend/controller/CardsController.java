package com.sparta.rhabbitbackend.controller;

import com.sparta.rhabbitbackend.dto.CardsDetailDto;
import com.sparta.rhabbitbackend.dto.CardsResponseDto;
import com.sparta.rhabbitbackend.model.Cards;
import com.sparta.rhabbitbackend.model.CardsDetail;
import com.sparta.rhabbitbackend.security.UserDetailsImpl;
import com.sparta.rhabbitbackend.service.CardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsController {
    private final CardsService cardsService;

    @PostMapping("/api/{cardId}/detail/todolist")      //카드에 리스트 추가하기, userId?
    public void createList(@PathVariable Long cardId, @RequestBody CardsDetailDto cardsDetailDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        cardsService.createDetail(cardId, cardsDetailDto, userDetails.getUser());
    }

    @GetMapping("/api/{cardId}/detail")     //수정하기 위한 카드 조회
    public Cards viewCards(@PathVariable Long cardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return cardsService.viewCards(userDetails.getUser(), cardId);
    }

    @GetMapping("/api/cards")       //메인화면
    public List<Cards> viewAllCards(UserDetailsImpl userDetails){
        return cardsService.viewAllCards(userDetails.getUser());
    }

    @PutMapping("/api/{cardId}/detail/update")      //리스트 수정
    public CardsDetail updateList(@PathVariable Long cardId, @RequestBody CardsDetailDto cardsDetailDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return cardsService.updateDetail(cardId, cardsDetailDto, userDetails.getUser());
    }

    @DeleteMapping("/api/{cardId}/detail/delete")       //리스트 삭제
    public void deleteList(@PathVariable Long cardId, @RequestBody CardsDetailDto cardsDetailDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        cardsService.deleteDetail(cardId, cardsDetailDto, userDetails.getUser());
    }

    @PostMapping("/api/cards") //최초 카드 가이드 생성, 전날 카드받아 오늘 카드 생성, 테스트용
    public Cards createFirstCard(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return cardsService.createCard(userDetails.getUser());

    }



}
