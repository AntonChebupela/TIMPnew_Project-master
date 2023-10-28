package com.company.service;

import com.company.domain.Account;

import java.util.List;

public interface AccountService {

    Account insert(Account account);

    Account update(int id, String balance);

    List<Account> getAll();

    Account getById(int id);

    Account getByNumber(String number);

    void deleteById(int id);
}
