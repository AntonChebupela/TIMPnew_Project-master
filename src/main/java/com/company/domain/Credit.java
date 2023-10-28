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
@Table(name = "credit")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Номер договора

    @Column(name = "name")
    private String clientName; //ФИО клиента

    @Column(name = "percent")
    private String percent; //Процент

    @Column(name = "period")
    private String period; //Срок

    @Column(name = "mon_pay")
    private String monthlyPayment; //ежемесячный платеж

    @Column(name = "sum")
    private String sum; //сумма кредита

    @Column(name = "requisites")
    private String requisites; //реквизиты

}
