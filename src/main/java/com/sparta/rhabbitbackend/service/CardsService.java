package com.sparta.rhabbitbackend.service;

import com.sparta.rhabbitbackend.dto.CardsDetailDto;
import com.sparta.rhabbitbackend.dto.CardsResponseDto;
import com.sparta.rhabbitbackend.model.Cards;
import com.sparta.rhabbitbackend.model.CardsDetail;
import com.sparta.rhabbitbackend.repository.CardsDetailRepository;
import com.sparta.rhabbitbackend.repository.CardsRepository;
import jdk.nashorn.internal.ir.Optimistic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.smartcardio.Card;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardsService {
    private final CardsRepository cardsRepository;
    private final CardsDetailRepository cardsDetailRepository;

    @Transactional
    public void createDetail(@PathVariable Long cardId, CardsDetailDto cardsDetailDto){   // 디테일 리스트 추가(모달)  text, checked, daily

        CardsDetail cardsDetail = CardsDetail.builder()
                .cardsId(cardId)
                .checked(cardsDetailDto.getChecked())
                .daily(cardsDetailDto.getChecked())
                .text(cardsDetailDto.getText())
                .build();

        cardsDetailRepository.save(cardsDetail);
    }

    @Transactional      //rate, List<cardsDetail>, date
    public Cards viewCards(Long cardId){
        Cards cards = cardsRepository.findById(cardId).orElseThrow(null);
        return cards;
    }

    @Transactional
    public List<Cards> viewAllCards(Long userId){   //카드 조회
        List<Cards> allCards = cardsRepository.findAll();
        return allCards;
    }

    @Transactional
    public Cards createFirstCard(Long userId ){     //첫 카드 생성
        List<CardsDetail> cardsDetail = new ArrayList<>();
        CardsDetail cardsDetail1 = CardsDetail.builder()
                .cardsId(null)
                .checked(false)
                .daily(false)
                .text("첫 계획")
                .build();
        cardsDetail.add(cardsDetail1);
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMdd");
        String formatedNow = now.format(formatter);
        Cards cards = Cards.builder()
                .userId(userId)
                .cardDetails(cardsDetail)
                .rate(0)
                .date(formatedNow)
                .build();

        cardsRepository.save(cards);

        return cards;
    }
}
