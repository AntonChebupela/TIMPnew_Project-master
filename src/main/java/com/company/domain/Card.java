package com.company.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //автоматически генерирует геттеры и сеттеры
@NoArgsConstructor  //Генерация конструктора без аргументов
@AllArgsConstructor //Конструктор со всеми аргументами
@Builder //Позволяет собирать объекты класса
@Entity
public class Card {

    @Id
    private int number; //Номер карты

    private String cardPeriod; //Срок действия карты

    private String personName; //Фио на карте

    private String cvv; //CVV код на обратной стороне карты

    private String codeForCheckCVV; //Код для проверки

    private String pinCode;

    private int account_id; //Счет, к которому привязана карта

}
