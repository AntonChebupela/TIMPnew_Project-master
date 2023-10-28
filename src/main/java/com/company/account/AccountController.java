package com.company.account;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountRepository accountRepository;

    @GetMapping
    ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(accountRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Account> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(accountRepository.getReferenceById(id));
    }

    @PostMapping
    ResponseEntity<Account> create(@RequestBody Account account) {
        return ResponseEntity.ok(accountRepository.save(account));
    }

    @PatchMapping("/{id}")
    ResponseEntity<Account> update(@PathVariable Integer id, @RequestBody Account updatedAccount) {
        return ResponseEntity.ok(accountRepository.findById(id).map(account -> {
            account.setBalance(updatedAccount.getBalance());
            account.setType(updatedAccount.getType());
            account.setOverdraftAllowed(updatedAccount.isOverdraftAllowed());
            return accountRepository.save(account);
        }).orElseThrow(() -> new RuntimeException("Failed to update account")));
    }

    @PatchMapping("/deposit/{id}")
    ResponseEntity<Account> depositMoney(@PathVariable Integer id, @RequestBody double amount) {
        return ResponseEntity.ok((accountRepository.findById(id).map(account -> {
            account.setBalance(account.getBalance() + amount);
            return accountRepository.save(account);
        }).orElseThrow(() -> new RuntimeException("Failed to deposit money to account"))));
    }
}
