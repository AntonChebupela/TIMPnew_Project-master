package com.company.service;

import com.company.domain.Deposit;
import com.company.repository.DepositRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepositServiceImpl implements DepositService{

    private final DepositRepository depositRepository;

    @Override
    public Deposit insert(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    @Override
    public Deposit update(int id, String name, String sum) {

        Deposit deposit = Deposit.builder()
                .id(id)
                .name(name)
                .sum(sum)
                .percent(depositRepository.getById(id).getPercent())
                .period(depositRepository.getById(id).getPercent())
                .requisites(depositRepository.getById(id).getRequisites())
                .abilityTopUp(depositRepository.getById(id).getAbilityTopUp())
                .abilityWithdraw(depositRepository.getById(id).getAbilityWithdraw())
                .build();

        return depositRepository.save(deposit);
    }

    @Override
    public List<Deposit> getAll() {
        return depositRepository.findAll();
    }

    @Override
    public Deposit getById(int id) {
        return depositRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        depositRepository.deleteById(id);
    }
}
