package com.company.service;

import com.company.domain.CardAccount;
import com.company.repository.CardAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardAccountServiceImpl implements CardAccountService{

    private final CardAccountRepository cardAccountRepository;


    @Override
    public CardAccount insert(CardAccount cardAccount) {
        return cardAccountRepository.save(cardAccount);
    }

    @Override
    public CardAccount update(int id, String name, String code, String cardNumber) {

        CardAccount cardAccount = CardAccount.builder()
                .id(id)
                .clientName(name)
                .birthday(getById(id).getBirthday())
                .accountCodeWord(code)
                .accountNumber(getById(id).getAccountNumber())
                .cardNumber(cardNumber).build();

        return cardAccountRepository.save(cardAccount);
    }

    @Override
    public List<CardAccount> getAll() {
        return cardAccountRepository.findAll();
    }

    @Override
    public CardAccount getById(int id) {
        return cardAccountRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        cardAccountRepository.deleteById(id);
    }
}
