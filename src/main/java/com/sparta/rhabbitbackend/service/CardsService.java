package com.sparta.rhabbitbackend.service;

import com.sparta.rhabbitbackend.dto.CardsDetailDto;
import com.sparta.rhabbitbackend.model.Cards;
import com.sparta.rhabbitbackend.model.CardsDetail;
import com.sparta.rhabbitbackend.model.User;
import com.sparta.rhabbitbackend.repository.CardsDetailRepository;
import com.sparta.rhabbitbackend.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardsService {
    private final CardsRepository cardsRepository;
    private final CardsDetailRepository cardsDetailRepository;

    @Transactional
    public void createDetail(@PathVariable Long cardId, CardsDetailDto cardsDetailDto, User user){   // 디테일 리스트 추가 text, checked, daily

        CardsDetail cardsDetail = CardsDetail.builder()
                .cardsId(cardId)
                .checked(cardsDetailDto.getChecked())
                .daily(cardsDetailDto.getChecked())
                .text(cardsDetailDto.getText())
                .build();

        cardsDetailRepository.save(cardsDetail);
    }

    @Transactional      //rate, List<cardsDetail>, date 수정하기 위한 카드 조회
    public Cards viewCards(User user, Long id){
        Cards cards = cardsRepository.findByUserIdAndId(user.getId(),id);
        return cards;
    }

    @Transactional
    public List<Cards> viewAllCards(User user){   //메인화면
        List<Cards> allCards = cardsRepository.findAllByUserId(user.getId());
        return allCards;
    }

    @Transactional
    public CardsDetail updateDetail(Long cardId, CardsDetailDto cardsDetailDto, User user){
        CardsDetail cardsDetail = CardsDetail.builder()
                .cardsId(cardId)
                .checked(cardsDetailDto.getChecked())
                .daily(cardsDetailDto.getChecked())
                .text(cardsDetailDto.getText())
                .build();
        cardsDetailRepository.save(cardsDetail);
        return cardsDetail;
    }

    @Transactional
    public void deleteDetail(Long cardId, CardsDetailDto cardsDetailDto, User user){
        cardsDetailRepository.deleteCardsDetailById(cardsDetailDto.getTextId());
    }

    @Transactional
    public Cards createCard(User user){     //첫 카드 생성, 00시 이후 카드 자동 생성
        List<CardsDetail> cardsDetail = new ArrayList<>();
        Cards yestCard = cardsRepository.findById(user.getId()).orElse(null);
        CardsDetail cardsDetail1 = CardsDetail.builder()
                .cardsId(null)
                .checked(false)
                .daily(false)
                .text("첫 계획")
                .build();
        cardsDetail.add(cardsDetail1);

        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMdd");
        String formatedNow = now.format(formatter);
        Cards cards = Cards.builder()
                .user(user)
                .cardDetails(cardsDetail)
                .date(formatedNow)
                .build();

        cardsRepository.save(cards);

        return cards;
    }
}
