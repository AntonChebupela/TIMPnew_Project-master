package com.company.user;

import com.company.account.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Date birthday;

    @OneToMany
    private List<Account> accounts;
}
