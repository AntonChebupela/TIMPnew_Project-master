package com.company.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data //автоматически генерирует геттеры и сеттеры
@NoArgsConstructor  //Генерация конструктора без аргументов
@AllArgsConstructor //Конструктор со всеми аргументами
@Builder //Позволяет собирать объекты класса
@Entity
@Table(name = "card")
public class Card {

    @Id
    @JoinColumn(name = "number")
    private int number; //Номер карты

    @Column(name = "period")
    private String cardPeriod; //Срок действия карты

    @Column(name = "name")
    private String personName; //Фио на карте

    @Column(name = "cvv")
    private String cvv; //CVV код на обратной стороне карты

    @Column(name = "code")
    private String codeForCheckCVV; //Код для проверки

    @Column(name = "pin")
    private String pinCode;

    @Column(name = "account_id")
    private int account_id; //Счет, к которому привязана карта

}
