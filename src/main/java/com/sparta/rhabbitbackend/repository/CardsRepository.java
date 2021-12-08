package com.sparta.rhabbitbackend.repository;

import com.sparta.rhabbitbackend.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsRepository extends JpaRepository<Cards, Long> {
}
