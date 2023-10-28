package com.company.repository;

import com.company.domain.Account;
import com.company.domain.CardAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Класс CardAccountRepositoryTest")
@DataJpaTest
public class CardAccountRepositoryTest {

    @Autowired
    private CardAccountRepository cardAccountRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @DisplayName("Должен добавлять договор")
    @Test
    void shouldInsertCardAccount() {
        int startSize = cardAccountRepository.findAll().size();

        CardAccount ca = CardAccount.builder()
                .clientName("Шевченко")
                .birthday("11.01.99")
                .accountCodeWord("Математика")
                .accountNumber("12")
                .cardNumber("12312").build();

        cardAccountRepository.save(ca);

        int endSize = cardAccountRepository.findAll().size();
        assertThat(endSize - startSize).isEqualTo(1);
    }

    @DisplayName("должен обновлять договор")
    @Test
    void shouldUpdateCardAccount() {
        CardAccount ca = CardAccount.builder()
                .id(1)
                .clientName("Шевченко")
                .birthday("11.01.99")
                .accountCodeWord("Математика")
                .accountNumber("12")
                .cardNumber("12312").build();
        cardAccountRepository.save(ca);
        assertThat(cardAccountRepository.getById(1)).isEqualTo(ca);
    }

    @DisplayName("должен возвращать все договора")
    @Test
    void shouldGetAllCardAccounts() {

        CardAccount ca = CardAccount.builder()
                .id(1)
                .clientName("Воронежский")
                .birthday("11.08.03")
                .accountCodeWord("Программирование")
                .accountNumber("1111111111111111")
                .cardNumber("231254").build();

        assertThat(cardAccountRepository.findAll().size()).isEqualTo(1);
        assertThat(cardAccountRepository.findAll()).contains(ca);
    }

    @DisplayName("должен возвращать договор по id")
    @Test
    void shouldGetCardAccountById() {
        CardAccount ca = CardAccount.builder()
                .id(1)
                .clientName("Воронежский")
                .birthday("11.08.03")
                .accountCodeWord("Программирование")
                .accountNumber("1111111111111111")
                .cardNumber("231254").build();
        assertThat(cardAccountRepository.getById(1)).isEqualTo(ca);
    }

    @DisplayName("должен удалять договор по id")
    @Test
    void shouldDeleteCardAccountById() {
        int startSize = cardAccountRepository.findAll().size();

        cardAccountRepository.deleteById(1);

        int endSize = cardAccountRepository.findAll().size();
        assertThat(startSize - endSize).isEqualTo(1);
    }


}
