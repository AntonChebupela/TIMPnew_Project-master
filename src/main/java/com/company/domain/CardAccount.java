package com.company.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="ca")
public class CardAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //номер договора

    @Column(name = "name")
    private String clientName; //Имя клиента

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "code")
    private String accountCodeWord; //Кодовое слово, необходимое для восстановления карты

    @Column(name = "caname")
    private String accountNumber; //Номер счета, к которому привязаны карты

    @Column(name = "number")
    private String cardNumber;

}
