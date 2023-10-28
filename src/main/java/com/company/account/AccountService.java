package com.company.account;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public boolean isTypeValid(String type) {
        return type.equals("CREDIT") ||
                type.equals("DEBIT") ||
                type.equals("SAVING") ||
                type.equals("BROKERAGE");
    }
}
