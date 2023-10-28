package com.company.repository;

import com.company.domain.Card;
import com.company.domain.Credit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Класс CreditRepositoryTest")
@DataJpaTest
public class CreditRepositoryTest {

    @Autowired
    private CreditRepository creditRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @DisplayName("Должен добавлять кредит")
    @Test
    void shouldInsertCredit() {
        int startSize = creditRepository.findAll().size();

        Credit credit = Credit.builder()
                .clientName("Шевченко")
                .percent("30%")
                .period("20 лет")
                .monthlyPayment("10000")
                .sum("100000000")
                .requisites("213123").build();

        creditRepository.save(credit);

        int endSize = creditRepository.findAll().size();
        assertThat(endSize - startSize).isEqualTo(1);
    }

    @DisplayName("должен обновлять кредит")
    @Test
    void shouldUpdateCredit() {

        Credit credit = Credit.builder()
                .id(1)
                .clientName("Шевченко")
                .percent("30%")
                .period("20 лет")
                .monthlyPayment("10000")
                .sum("100000000")
                .requisites("213123").build();

        creditRepository.save(credit);
        assertThat(creditRepository.getById(1)).isEqualTo(credit);
    }

    @DisplayName("должен возвращать все кредиты")
    @Test
    void shouldGetAllCredit() {

        Credit credit = Credit.builder()
                .id(1)
                .clientName("Воронежский Никита Максимович")
                .percent("53%")
                .period("5 лет")
                .monthlyPayment("10000")
                .sum("10000000")
                .requisites("213123").build();

        assertThat(creditRepository.findAll().size()).isEqualTo(1);
        assertThat(creditRepository.findAll()).contains(credit);
    }


    @DisplayName("должен возвращать кредит по номеру")
    @Test
    void shouldGetCreditById() {

        Credit credit = Credit.builder()
                .id(1)
                .clientName("Воронежский Никита Максимович")
                .percent("53%")
                .period("5 лет")
                .monthlyPayment("10000")
                .sum("10000000")
                .requisites("213123").build();

        assertThat(creditRepository.getById(1)).isEqualTo(credit);
    }

    @DisplayName("должен удалять кредит по id")
    @Test
    void shouldDeleteCreditById() {
        int startSize = creditRepository.findAll().size();

        creditRepository.deleteById(1);

        int endSize = creditRepository.findAll().size();
        assertThat(startSize - endSize).isEqualTo(1);
    }
}
