package com.company.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private double balance;
    private boolean overdraftAllowed;
    private String type;
    private Integer userId;

    public AccountDto(String type, Integer userId) {
        balance = 0;
        overdraftAllowed = false;
        this.type = type;
        this.userId = userId;
    }
}
