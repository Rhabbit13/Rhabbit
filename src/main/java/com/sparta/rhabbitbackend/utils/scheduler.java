package com.sparta.rhabbitbackend.utils;

import com.sparta.rhabbitbackend.dto.CardsDetailDto;
import com.sparta.rhabbitbackend.dto.CardsResponseDto;
import com.sparta.rhabbitbackend.model.Cards;
import com.sparta.rhabbitbackend.model.CardsDetail;
import com.sparta.rhabbitbackend.model.User;
import com.sparta.rhabbitbackend.repository.CardsDetailRepository;
import com.sparta.rhabbitbackend.repository.CardsRepository;
import com.sparta.rhabbitbackend.repository.UserRepository;
import com.sparta.rhabbitbackend.service.CardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//@RequiredArgsConstructor
//@Component
public class scheduler {
//    private final UserRepository userRepository;
//    private final CardsRepository cardsRepository;
//    private final CardsService cardsService;
//    private final CardsDetailRepository cardsDetailRepository;
//    //임시로 1분마다 카드 생성
//    @Scheduled(cron = "0 */1 * * * * ")   //매일 00시에 실행? 초 분 시 dayofmonth month dayofweek years
//    public void createCard(){
//        System.out.println("카드 생성");
//        List<CardsDetail> cardsDetails = new ArrayList<>();
//        List<User> userList = userRepository.findAll();
//
//        for(User user : userList){      //모든유저 조회
//            List<CardsDetailDto> cardsDetailDtos = new ArrayList<>();
//
//            LocalDate now = LocalDate.now();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMdd");
//            String formatedNow = now.format(formatter);
////유저아이디->카드->카드디테일->데일리트루?  ==> 유저 아이디랑 details가 연결되있지 않음. ==> cardrepo를 거쳐야하나?
//            Cards cards = Cards.builder()
//                    .user(user)
//                    .date(formatedNow)
//                    .build();
//
//            cardsRepository.save(cards);
//
//            CardsDetail cardsDetail;
//            List<Cards> cardsList = cardsRepository.findAll();
//            Long maxCardId = Integer.toUnsignedLong(cardsList.size());
//
//            if(cardsDetailRepository.findAllByDailyAndCardsId(true, maxCardId) == null || cardsRepository.findAllByUserId(user.getId()) == null){     //Daily = true가 없을때 card 생성, 카드가 하나도 없을 떄
//                cardsDetail = CardsDetail.builder()
//                        .cardsId(maxCardId)
//                        .daily(false)
//                        .checked(false)
//                        .text("첫 계획을 세워보세요!")
//                        .build();
//                cardsDetails.add(cardsDetail);
//                cardsDetailRepository.save(cardsDetail);
//            }
//            else{
//                for(CardsDetail details: cardsDetailRepository.findAllByDailyAndCardsId(true, maxCardId)){
//                    cardsDetail = CardsDetail.builder()
//                            .cardsId(maxCardId)
//                            .daily(details.getDaily())
//                            .checked(false)
//                            .text(details.getText())
//                            .build();
//                    cardsDetails.add(cardsDetail);
//                    cardsDetailRepository.save(cardsDetail);
//                }
//            }
//            //cardsRepository.save(cards1);
//        }
//
//    }

}
