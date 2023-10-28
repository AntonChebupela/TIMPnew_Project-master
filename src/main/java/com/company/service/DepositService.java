package com.company.service;

import com.company.domain.Deposit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepositService {

    Deposit insert(Deposit deposit);

    Deposit update(int id, String name, String sum);

    List<Deposit> getAll();

    Deposit getById(int id);

    void deleteById(int id);
}
