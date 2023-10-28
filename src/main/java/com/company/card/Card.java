package com.company.card;

import com.company.account.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int number;
    private String cardPeriod;
    private String name;
    private String cvv;

    private String codeForCheckCVV;
    private String pinCode;

    @ManyToOne
    private Account account;

}
