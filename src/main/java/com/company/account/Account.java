package com.company.account;

import com.company.card.Card;
import com.company.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double balance;
    private boolean overdraftAllowed;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Card> cards;
    public Account(AccountDto dto, User user) {
        balance = dto.getBalance();
        overdraftAllowed = dto.isOverdraftAllowed();
        type = AccountType.valueOf(dto.getType());
        this.user = user;
    }

}
