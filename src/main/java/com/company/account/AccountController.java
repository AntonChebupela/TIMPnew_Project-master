package com.company.account;

import com.company.user.Role;
import com.company.user.User;
import com.company.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final AccountService accountService;

    @GetMapping("/user/{userId}")
    ResponseEntity<List<Account>> getByUser(@PathVariable Integer userId) {
        Optional<User> optUser = userRepository.findById(userId);
        return optUser.map(user -> ResponseEntity.ok(accountRepository.findAllByUser(user)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    ResponseEntity<AccountDto> getById(@PathVariable Integer id) {
        Account account = accountRepository.getReferenceById(id);
        return ResponseEntity.ok(new AccountDto(
                account.getBalance(),
                account.isOverdraftAllowed(),
                account.getType().toString(),
                account.getUser().getId()
        ));
    }

    @PostMapping
    ResponseEntity<Account> create(@RequestBody AccountDto dto) {
        String type = dto.getType();
        Integer userId = dto.getUserId();
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Cannot find user with id " + userId));
        if (accountService.isTypeValid(type) && user.getRole() == Role.CLIENT) {
            Account newAccount = accountRepository.save(new Account(dto, user));
            return ResponseEntity.ok(newAccount);
        }
        return ResponseEntity.badRequest().build();
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
