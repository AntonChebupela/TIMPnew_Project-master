package com.company.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CardAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //номер договора

    private String clientName; //Имя клиента

    private String birthday;

    private String accountCodeWord; //Кодовое слово, необходимое для восстановления карты

    private String accountNumber; //Номер счета, к которому привязаны карты

    private String cardNumber;

}
