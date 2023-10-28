package com.company.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //автоматически генерирует геттеры и сеттеры
@NoArgsConstructor  //Генерация конструктора без аргументов
@AllArgsConstructor //Конструктор со всеми аргументами
@Builder //Позволяет собирать объекты класса
@Entity
@Table(name = "deposit")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //номер договора

    private String name;

    private String sum; //минимальный вклад

    private String percent; //процент годовых

    private String period; // срок депозита

    private String requisites; //реквизиты

    private String abilityTopUp; //возможность пополнить баланс

    private String abilityWithdraw; //возможность снять средства

}
