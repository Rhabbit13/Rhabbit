package com.sparta.rhabbitbackend.service;

import com.sparta.rhabbitbackend.dto.CardsDetailDto;
import com.sparta.rhabbitbackend.dto.CardsRequestDto;
import com.sparta.rhabbitbackend.dto.CardsResponseDto;
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

    //메인화면-모든 카드 불러오기
    @Transactional
    public List<CardsResponseDto> viewAllCards(User user){
        List<Cards> cardsList = cardsRepository.findAllByUserId(user.getId());
        List<CardsResponseDto> cardsResponseDtos = new ArrayList<>();
        for (Cards cards: cardsList){
            CardsResponseDto cardsResponseDto = new CardsResponseDto(cards);
            cardsResponseDtos.add(cardsResponseDto);
        }
        return cardsResponseDtos;
    }

    //디테일 화면
    @Transactional
    public CardsResponseDto viewCards(User user, Long cardId){
        Cards cards = cardsRepository.findByUserIdAndId(user.getId(),cardId);
        return new CardsResponseDto(cards);
    }

    // 디테일 리스트 추가 text, checked, daily
    @Transactional
    public CardsDetailDto createDetail(Long cardId, CardsRequestDto cardsRequestDto, User user){
        Cards cards = cardsRepository.findById(cardId)
                .orElseThrow(() -> new NullPointerException("해당 카드가 존재하지 않습니다."));

        CardsDetail cardsDetail = CardsDetail.builder()
                .cardsId(cardId)
                .text(cardsRequestDto.getText())
                .checked(cardsRequestDto.getChecked())
                .daily(cardsRequestDto.getDaily())
                .build();
        cardsDetailRepository.save(cardsDetail);

        return CardsDetailDto.builder()
                .textId(cardsDetail.getId())
                .text(cardsDetail.getText())
                .checked(cardsDetail.getChecked())
                .daily(cardsDetail.getDaily())
                .build();
    }

    //
    @Transactional
    public void updateDetail(Long cardId, CardsDetailDto cardsDetailDto, User user){
        CardsDetail cardsDetail = cardsDetailRepository.findById(cardsDetailDto.getTextId())
                .orElseThrow(() -> new NullPointerException("해당 리스트가 존재하지 않습니다."));

        cardsDetail.update(cardsDetailDto);
    }

    //삭제
    @Transactional
    public void deleteDetail(Long textId){
        cardsDetailRepository.deleteCardsDetailById(textId);
    }

    @Transactional
    public Cards createCard(User user){     //첫 카드 생성, 00시 이후 카드 자동 생성
        List<CardsDetail> cardsDetail = new ArrayList<>();
        Cards yestCard = cardsRepository.findById(user.getId()).orElse(null);
        CardsDetail cardsDetail1 = CardsDetail.builder()
                .cardsId()
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
