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
        List<CardsResponseDto> cardsResponseDtoList = new ArrayList<>();

        List<Cards> cardsList = cardsRepository.findAllByUserId(user.getId());

        for(Cards cards : cardsList){
        List<CardsDetail> cardsDetailList = cardsDetailRepository.findAllByCardsId(cards.getId());
        List<CardsDetailDto> cardsDetailDtoList = new ArrayList<>();
            for(CardsDetail cardsDetail : cardsDetailList){
                CardsDetailDto cardsDetailDto = CardsDetailDto.builder()
                        .textId(cardsDetail.getId())
                        .daily(cardsDetail.getDaily())
                        .text(cardsDetail.getText())
                        .checked(cardsDetail.getChecked())
                        .build();
                cardsDetailDtoList.add(cardsDetailDto);
            }
            CardsResponseDto cardsResponseDto = CardsResponseDto.builder()
                    .cardsId(cards.getId())
                    .date(cards.getDate())
                    .userId(user.getId())
                    .cardsDetailDtos(cardsDetailDtoList)
                    .nickname(user.getNickname())
                    .build();
            cardsResponseDtoList.add(cardsResponseDto);

        }
        return cardsResponseDtoList;
    }

    //디테일 화면
    @Transactional
    public CardsResponseDto viewCards(User user, Long cardId){
        Cards cards = cardsRepository.findByUserIdAndId(user.getId(), cardId);

        List<CardsDetail> cardsDetailList = cardsDetailRepository.findAllByCardsId(cardId);
        List<CardsDetailDto> cardsDetailDtoList = new ArrayList<>();
        for(CardsDetail cardsDetail : cardsDetailList){
            CardsDetailDto cardsDetailDto = CardsDetailDto.builder()
                    .textId(cardsDetail.getId())
                    .daily(cardsDetail.getDaily())
                    .text(cardsDetail.getText())
                    .checked(cardsDetail.getChecked())
                    .build();
            cardsDetailDtoList.add(cardsDetailDto);
        }
        CardsResponseDto cardsResponseDto = CardsResponseDto.builder()
                .cardsId(cards.getId())
                .date(cards.getDate())
                .nickname(user.getNickname())
                .userId(user.getId())
                .cardsDetailDtos(cardsDetailDtoList)
                .build();
        return cardsResponseDto;
    }

    // 디테일 리스트 추가 text, checked, daily
    @Transactional
    public CardsDetailDto createDetail(Long cardId, CardsRequestDto cardsRequestDto, User user){
        Cards cards = cardsRepository.findById(cardId)
                .orElseThrow(() -> new NullPointerException("해당 카드가 존재하지 않습니다."));

        CardsDetail cardsDetail = CardsDetail.builder()
                .cards(cards)
                .user(user)
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

    //업데이트
    @Transactional
    public void updateDetail(Long cardId, CardsDetailDto cardsDetailDto, User user){
        CardsDetail cardsDetail = cardsDetailRepository.findById(cardsDetailDto.getTextId())
                .orElseThrow(() -> new NullPointerException("해당 리스트가 존재하지 않습니다."));

        cardsDetail.update(cardsDetailDto);
    }

    //삭제
    @Transactional
    public void deleteDetail(Long textId, Long cardsId){
        cardsDetailRepository.deleteCardsDetailByIdAndCardsId(textId, cardsId);
    }

    @Transactional
    public CardsResponseDto createCard(User user){
        LocalDate now = LocalDate.now();        //현재날짜 계산
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMdd");
        String formatedNow = now.format(formatter);

        Cards cards = Cards.builder()       //첫 카드 작성
                .date(formatedNow)
                .user(user)
                .build();
        cardsRepository.save(cards);

        List<CardsDetailDto> cardsDetailDtos = new ArrayList<>();       //첫 내용 작성
        CardsDetailDto cardsDetailDto = CardsDetailDto.builder()
                .textId(1L)
                .text("첫 계획을 작성해 보세요")
                .checked(false)
                .daily(false)
                .build();
        cardsDetailDtos.add(cardsDetailDto);

        CardsDetail cardsDetail = CardsDetail.builder()         //내용 저장
                .cards(cards)
                .checked(cardsDetailDto.getChecked())
                .daily(cardsDetailDto.getDaily())
                .text(cardsDetailDto.getText())
                .user(user)
                .build();
        cardsDetailRepository.save(cardsDetail);

        CardsResponseDto cardsResponseDto = CardsResponseDto.builder()
                .cardsId(cards.getId())
                .date(cards.getDate())
                .userId(user.getId())
                .cardsDetailDtos(cardsDetailDtos)
                .nickname(user.getNickname())
                .build();
        return cardsResponseDto;
    }
}