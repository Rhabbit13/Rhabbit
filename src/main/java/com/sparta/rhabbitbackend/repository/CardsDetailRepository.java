package com.sparta.rhabbitbackend.repository;

import com.sparta.rhabbitbackend.model.CardsDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsDetailRepository extends JpaRepository<CardsDetail, Long> {
    List<CardsDetail> findAllByCardsId(Long cardsId);
    void deleteCardsDetailByIdAndCardsId(Long id, Long cardsId);
    List<CardsDetail> findAllByDailyAndCardsId(Boolean daily, Long cardsId);
}
