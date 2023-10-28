package com.company.service;

import com.company.domain.Card;

import java.util.List;

public interface CardService {

    Card insert(Card card);

    Card update(int number, String code, String pin);

    List<Card> getAll();

    Card getById(int number);

    void deleteByNumber(int number);
}
