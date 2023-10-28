package com.company.service;

import com.company.domain.CardAccount;

import java.util.List;

public interface CardAccountService {

    CardAccount insert(CardAccount cardAccount);

    CardAccount update(int id, String name, String code, String cardNumber);

    List<CardAccount> getAll();

    CardAccount getById(int id);

    void deleteById(int id);
}
