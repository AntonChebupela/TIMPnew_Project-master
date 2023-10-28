package com.company.rest.dto;

import com.company.domain.Deposit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepositDto {

    private int id; //номер договора

    private String name;

    private String sum; //минимальный вклад

    private String percent; //процент годовых

    private String period; // срок депозита

    private String requisites; //реквизиты

    private String abilityTopUp; //возможность пополнить баланс

    private String abilityWithdraw; //возможность снять средства

    public static Deposit toDomainObject(DepositDto depositDto) {
        return new Deposit(depositDto.getId(), depositDto.getName(), depositDto.getSum(), depositDto.getPercent(),
                depositDto.getPeriod(), depositDto.getRequisites(), depositDto.getAbilityTopUp(), depositDto.getAbilityWithdraw());
    }

    public static DepositDto toDto(Deposit deposit) {
        return new DepositDto(deposit.getId(), deposit.getName(), deposit.getSum(), deposit.getPercent(),
                deposit.getPeriod(), deposit.getRequisites(), deposit.getAbilityTopUp(), deposit.getAbilityWithdraw());
    }
}
