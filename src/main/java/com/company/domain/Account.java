package com.company.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String account; //Номер счета

    private double balance; //Баланс


}
