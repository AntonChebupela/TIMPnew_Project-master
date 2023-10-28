package com.company.repository;

import com.company.domain.Account;
import com.company.domain.Deposit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Класс DepositRepositoryTest")
@DataJpaTest
public class DepositRepositoryTest {

    @Autowired
    private DepositRepository depositRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @DisplayName("Должен добавлять депозит")
    @Test
    void shouldInsertDeposit() {

        int startSize = depositRepository.findAll().size();

        Deposit deposit = Deposit.builder()
                .name("Шевченко")
                .sum("5000")
                .period("20 лет")
                .percent("10%")
                .requisites("123412312")
                .abilityTopUp("Да")
                .abilityWithdraw("Да").build();

        depositRepository.save(deposit);

        int endSize = depositRepository.findAll().size();

        assertThat(endSize - startSize).isEqualTo(1);

    }

    @DisplayName("должен обновлять депозит")
    @Test
    void shouldUpdateDeposit() {
        Deposit expDeposit = Deposit.builder()
                .id(1)
                .name("Шевченко")
                .sum("5000")
                .period("20 лет")
                .percent("10%")
                .requisites("123412312")
                .abilityTopUp("Да")
                .abilityWithdraw("Да").build();

        depositRepository.save(expDeposit);
        Deposit acDeposit = depositRepository.getById(1);

        assertThat(acDeposit).isEqualTo(expDeposit);
    }

    @DisplayName("должен возвращать все депозиты")
    @Test
    void shouldGetAllDeposits() {
        Deposit expDeposit = Deposit.builder()
                .id(1)
                .name("Шевченко")
                .sum("5000")
                .period("20 лет")
                .percent("10%")
                .requisites("123412312")
                .abilityTopUp("Да")
                .abilityWithdraw("Да").build();
        depositRepository.save(expDeposit);

        assertThat(depositRepository.findAll().size()).isEqualTo(1);
        assertThat(depositRepository.findAll()).contains(expDeposit);
    }

    @DisplayName("должен возвращать депозит по id")
    @Test
    void shouldGetDepositById() {

        Deposit expDeposit = Deposit.builder()
                .id(1)
                .name("Шевченко")
                .sum("5000")
                .period("20 лет")
                .percent("10%")
                .requisites("123412312")
                .abilityTopUp("Да")
                .abilityWithdraw("Да").build();
        depositRepository.save(expDeposit);

        Deposit deposit1 = depositRepository.getById(1);

        assertThat(deposit1).isEqualTo(expDeposit);
    }


    @DisplayName("должен удалять депозит по id")
    @Test
    void shouldDeleteDepositById() {
        int startSize = depositRepository.findAll().size();

        depositRepository.deleteById(1);

        int endSize = depositRepository.findAll().size();

        assertThat(startSize - endSize).isEqualTo(1);

    }
}
