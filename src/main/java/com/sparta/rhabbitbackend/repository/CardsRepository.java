package com.sparta.rhabbitbackend.repository;

import com.sparta.rhabbitbackend.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsRepository extends JpaRepository<Cards, Long> {
    List<Cards> findAllByUserId(Long userId);
    Cards findByUserIdAndId(Long userId, Long cardId);

    Boolean existsByUserId(Long id);
}
