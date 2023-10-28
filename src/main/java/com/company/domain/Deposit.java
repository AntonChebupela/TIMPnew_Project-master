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
@Table(name = "deposit")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //номер договора

    @Column(name = "name")
    private String name;

    @Column(name = "sum")
    private String sum; //минимальный вклад

    @Column(name = "percent")
    private String percent; //процент годовых

    @Column(name = "period")
    private String period; // срок депозита

    @Column(name = "requisites")
    private String requisites; //реквизиты

    @Column(name = "atu")
    private String abilityTopUp; //возможность пополнить баланс

    @Column(name = "aw")
    private String abilityWithdraw; //возможность снять средства

}
