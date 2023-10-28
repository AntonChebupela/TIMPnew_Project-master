package com.company.service;

import com.company.domain.Account;
import com.company.repository.AccountRepository;
import com.company.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    @Override
    public Account insert(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(int id, String balance) {
        Account account = Account.builder()
                .id(id)
                .account(accountRepository.getById(id).getAccount())
                .balance(Double.parseDouble(balance)).build();
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account getById(int id) {
        return accountRepository.getById(id);
    }

    @Override
    public Account getByNumber(String number) {
        return accountRepository.findByAccount(number);
    }

    @Override
    public void deleteById(int id) {
        accountRepository.deleteById(id);
    }
}
