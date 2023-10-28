package com.company.service;

import com.company.domain.Credit;

import java.util.List;

public interface CreditService {

    Credit insert(Credit credit);

    Credit update(int id, String name, String sum);

    List<Credit> getAll();

    Credit getById(int id);

    void deleteById(int id);
}
