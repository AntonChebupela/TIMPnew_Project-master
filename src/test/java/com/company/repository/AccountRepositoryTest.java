package com.company.repository;

import com.company.domain.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Класс AccountRepositoryTest")
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @DisplayName("Должен добавлять счет")
    @Test
    void shouldInsertAccount() {

        int startSize = accountRepository.findAll().size();

        Account account = Account.builder()
                .account("453456345")
                .balance(111.11)
                .build();

        accountRepository.save(account);

        int endSize = accountRepository.findAll().size();

        assertThat(endSize - startSize).isEqualTo(1);

    }

    @DisplayName("должен обновлять счет")
    @Test
    void shouldUpdateAccount() {
        Account expAccount = Account.builder()
                .id(1)
                .account("222")
                .balance(123)
                .build();

        accountRepository.save(expAccount);
        Account acAccount = accountRepository.getById(1);

        assertThat(acAccount).isEqualTo(expAccount);
    }

    @DisplayName("должен возвращать все счета")
    @Test
    void shouldGetAllAccounts() {
        Account account = Account.builder().id(1).account("1111111111111111").balance(0).build();

        assertThat(accountRepository.findAll().size()).isEqualTo(1);
        assertThat(accountRepository.findAll()).contains(account);
    }

    @DisplayName("должен возвращать счет по id")
    @Test
    void shouldGetAccountById() {

        Account account = Account.builder().id(1).account("1111111111111111").balance(0).build();

        Account account1 = accountRepository.findById(1);

        assertThat(account1).isEqualTo(account);
    }

    @DisplayName("должен возвращать счет по номеру")
    @Test
    void shouldGetAccountByName() {

        Account account = Account.builder().id(1).account("1111111111111111").balance(0).build();

        Account account1 = accountRepository.findByAccount("1111111111111111");

        assertThat(account1).isEqualTo(account);
    }

    @DisplayName("должен удалять счет по id")
    @Test
    void shouldDeleteAccountById() {
        int startSize = accountRepository.findAll().size();

        accountRepository.deleteById(1);

        int endSize = accountRepository.findAll().size();

        assertThat(startSize - endSize).isEqualTo(1);

    }


}
