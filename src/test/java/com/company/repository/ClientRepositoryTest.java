package com.company.repository;

import com.company.domain.Client;
import com.company.domain.Deposit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Класс ClientRepositoryTest")
@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @DisplayName("Должен добавлять клиент")
    @Test
    void shouldInsertClient() {

        int startSize = clientRepository.findAll().size();

        Client client = Client.builder()
                .id(2)
                .name("Шевченко")
                .birthday("11.01.99")
                .credits(1)
                .cardAccount(2)
                .deposits(2)
                .build();

        clientRepository.save(client);

        int endSize = clientRepository.findAll().size();

        assertThat(endSize - startSize).isEqualTo(1);

    }

    @DisplayName("должен обновлять клиент")
    @Test
    void shouldUpdateDeposit() {
        Client client = Client.builder()
                .id(1)
                .name("Шевченко")
                .birthday("11.01.99")
                .credits(1)
                .cardAccount(2)
                .deposits(2)
                .build();

        clientRepository.save(client);
        Client acClient = clientRepository.getById(1);

        assertThat(acClient).isEqualTo(client);
    }

    @DisplayName("должен возвращать всех клиентов")
    @Test
    void shouldGetAllDeposits() {
        Client client = Client.builder()
                .id(1)
                .name("Шевченко")
                .birthday("11.01.99")
                .credits(1)
                .cardAccount(2)
                .deposits(2)
                .build();
        clientRepository.save(client);

        assertThat(clientRepository.findAll().size()).isEqualTo(1);
        assertThat(clientRepository.findAll()).contains(client);
    }

    @DisplayName("должен возвращать клиента по id")
    @Test
    void shouldGetDepositById() {

        Client client = Client.builder()
                .id(1)
                .name("Шевченко")
                .birthday("11.01.99")
                .credits(1)
                .cardAccount(2)
                .deposits(2)
                .build();
        clientRepository.save(client);

        Client client1 = clientRepository.getById(1);

        assertThat(client1).isEqualTo(client);
    }

    @DisplayName("должен возвращать клиента по name")
    @Test
    void shouldGetDepositByName() {

        Client client = Client.builder()
                .id(1)
                .name("Шевченко")
                .birthday("11.01.99")
                .credits(1)
                .cardAccount(2)
                .deposits(2)
                .build();
        clientRepository.save(client);

        Client client1 = clientRepository.findByName("Шевченко");

        assertThat(client1).isEqualTo(client);
    }


    @DisplayName("должен удалять клиента по id")
    @Test
    void shouldDeleteDepositById() {
        int startSize = clientRepository.findAll().size();

        clientRepository.deleteById(1);

        int endSize = clientRepository.findAll().size();

        assertThat(startSize - endSize).isEqualTo(1);

    }
}
