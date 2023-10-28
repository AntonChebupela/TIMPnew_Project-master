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
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Номер клиента

    private String name; //ФИО

    private String birthday; //Дата рождения


    private int credits; //Кредитные договоры



    private int deposits; //Депозитные договоры


    private int cardAccount; //Договоры, по карточным счетам

}
