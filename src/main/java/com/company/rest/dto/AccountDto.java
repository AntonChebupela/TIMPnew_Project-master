package com.company.rest.dto;


import com.company.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private int id;

    private String account;

    private double balance;

    public static Account toDomainObject(AccountDto accountDto) {
        return new Account(accountDto.getId(), accountDto.getAccount(), accountDto.getBalance());
    }

    public static AccountDto toDto(Account account) {
        return new AccountDto(account.getId(), account.getAccount(), account.getBalance());
    }
}
