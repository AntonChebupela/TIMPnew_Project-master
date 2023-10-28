package com.company.user;

import com.company.account.Account;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthday;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany
    private List<Account> accounts;
    public User(UserDto dto) {
        name = dto.getName();
        birthday = dto.getBirthday();
        role = Role.valueOf(dto.getRole());
    }
}
