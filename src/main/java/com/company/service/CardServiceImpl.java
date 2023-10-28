package com.company.service;

import com.company.domain.Card;
import com.company.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;


    @Override
    public Card insert(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card update(int number, String code, String pin) {

        Card newCard = Card.builder()
                .number(number)
                .cardPeriod(getById(number).getCardPeriod())
                .personName(getById(number).getPersonName())
                .cvv(getById(number).getCvv())
                .codeForCheckCVV(code)
                .pinCode(pin)
                .account_id(getById(number).getAccount_id())
                .build();

        return cardRepository.save(newCard);
    }

    @Override
    public List<Card> getAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card getById(int number) {
        return cardRepository.getById(number);
    }

    @Override
    public void deleteByNumber(int number) {
        cardRepository.deleteById(number);
    }
}
