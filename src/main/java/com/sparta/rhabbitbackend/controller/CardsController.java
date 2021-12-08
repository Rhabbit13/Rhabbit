package com.sparta.rhabbitbackend.controller;

import com.sparta.rhabbitbackend.dto.CardsDetailDto;
import com.sparta.rhabbitbackend.model.Cards;
import com.sparta.rhabbitbackend.service.CardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.Card;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsController {
    private final CardsService cardsService;

    @PostMapping("/api/{cardsId}/postList")      //상세 리스트 작성
    public void createList(@PathVariable Long cardsId, @RequestBody CardsDetailDto cardsDetailDto){
        cardsService.createDetail(cardsId, cardsDetailDto);
    }

    @GetMapping("/api/{cardId}/detail")     //전체 카드 조회?
    public Cards viewCards(@PathVariable Long cardId){
        return cardsService.viewCards(cardId);
    }
    @PostMapping("/api/{userId}/cards") //최초 카드 가이드 생성
    public List<Cards> viewAllCards(@PathVariable Long userId){
        return cardsService.viewAllCards(userId);
    }

    @PostMapping("/guide/{userId}")
    public Cards createFirstCard(@PathVariable Long userId){
        return cardsService.createFirstCard(userId);
    }
}
