package com.company.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "name")
    private String name; //ФИО

    @Column(name = "birthday")
    private String birthday; //Дата рождения


    @Column(name = "credit_id")
    private int credits; //Кредитные договоры


    @Column(name = "deposit_id")
    private int deposits; //Депозитные договоры


    @Column(name = "ca_id")
    private int cardAccount; //Договоры, по карточным счетам

}
