package com.company.service;

import com.company.domain.CardAccount;
import com.company.domain.Client;
import com.company.domain.Credit;
import com.company.domain.Deposit;

import java.util.List;

public interface ClientService {

    Client insert(Client client);

    Client update(int id, String name, int cardAccount, int credit, int deposit);

    List<Client> getAll();

    Client getById(int id);

    void deleteById(int id);

    Client getByName(String name);
}
