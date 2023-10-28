package com.company.service;

import com.company.domain.Credit;
import com.company.repository.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService{

    private final CreditRepository creditRepository;

    @Override
    public Credit insert(Credit credit) {
        return creditRepository.save(credit);
    }

    @Override
    public Credit update(int id, String name, String sum) {

        Credit credit = Credit.builder()
                .id(id)
                .clientName(name)
                .period(creditRepository.getById(id).getPeriod())
                .monthlyPayment(creditRepository.getById(id).getMonthlyPayment())
                .sum(sum)
                .requisites(creditRepository.getById(id).getRequisites())
                .build();


        return creditRepository.save(credit);
    }

    @Override
    public List<Credit> getAll() {
        return creditRepository.findAll();
    }

    @Override
    public Credit getById(int id) {
        return creditRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        creditRepository.deleteById(id);
    }
}
