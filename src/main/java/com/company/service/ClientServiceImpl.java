package com.company.service;

import com.company.domain.CardAccount;
import com.company.domain.Client;
import com.company.domain.Credit;
import com.company.domain.Deposit;
import com.company.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    @Override
    public Client insert(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public Client update(int id, String name, int cardAccount, int credit, int deposit) {

        Client client = Client.builder()
                .id(id)
                .name(name)
                .cardAccount(cardAccount)
                .credits(credit)
                .deposits(deposit)
                .build();

        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(int id) {
        return clientRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client getByName(String name) {
        return clientRepository.findByName(name);
    }
}
