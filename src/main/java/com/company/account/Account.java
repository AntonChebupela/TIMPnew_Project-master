package com.company.account;

import com.company.card.Card;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double balance;
    private boolean overdraftAllowed;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @OneToMany
    private List<Card> cards;

}
