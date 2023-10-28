package com.company.repository;

import com.company.domain.Card;
import com.company.domain.CardAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Класс CardRepositoryTest")
@DataJpaTest
public class CardRepositoryTest {

    @Autowired
    private CardRepository cardRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @DisplayName("Должен добавлять карту")
    @Test
    void shouldInsertCard() {
        int startSize = cardRepository.findAll().size();
        Card card = Card.builder()
                .number(1236324)
                .cardPeriod("123")
                .personName("Шевченко")
                .cvv("233")
                .codeForCheckCVV("Timp")
                .pinCode("3234")
                .account_id(2)
                .build();

        cardRepository.save(card);

        int endSize = cardRepository.findAll().size();
        assertThat(endSize - startSize).isEqualTo(1);
    }

    @DisplayName("должен обновлять карту")
    @Test
    void shouldUpdateCard() {

        Card card = Card.builder()
                .number(231254)
                .cardPeriod("123")
                .personName("Шевченко")
                .cvv("233")
                .codeForCheckCVV("Timp")
                .pinCode("3234")
                .account_id(2)
                .build();
        cardRepository.save(card);
        assertThat(cardRepository.getById(231254)).isEqualTo(card);
    }

    @DisplayName("должен возвращать все карты")
    @Test
    void shouldGetAllCard() {

        Card card = Card.builder()
                .number(231254)
                .cardPeriod("23.05.12")
                .personName("Воронежский")
                .cvv("333")
                .codeForCheckCVV("Программирование")
                .pinCode("2226")
                .account_id(1)
                .build();

        assertThat(cardRepository.findAll().size()).isEqualTo(1);
        assertThat(cardRepository.findAll()).contains(card);
    }


    @DisplayName("должен возвращать карту по номеру")
    @Test
    void shouldGetCardByNumber() {
        Card card = Card.builder()
                .number(231254)
                .cardPeriod("23.05.12")
                .personName("Воронежский")
                .cvv("333")
                .codeForCheckCVV("Программирование")
                .pinCode("2226")
                .account_id(1)
                .build();
        assertThat(cardRepository.getById(231254)).isEqualTo(card);
    }

    @DisplayName("должен удалять карту по id")
    @Test
    void shouldDeleteCardById() {
        int startSize = cardRepository.findAll().size();

        cardRepository.deleteById(231254);

        int endSize = cardRepository.findAll().size();
        assertThat(startSize - endSize).isEqualTo(1);
    }
}
