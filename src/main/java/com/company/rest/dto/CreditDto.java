package com.company.rest.dto;


import com.company.domain.Credit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditDto {

    private int id;

    private String clientName;

    private String percent;

    private String period;

    private String monthlyPayment;

    private String sum;

    private String requisites;

    public static Credit toDomainObject(CreditDto creditDto) {
        return new Credit(creditDto.getId(), creditDto.getClientName(), creditDto.getPercent(), creditDto.getPeriod(),
                creditDto.getMonthlyPayment(), creditDto.getSum(), creditDto.getRequisites());
    }

    public static CreditDto toDto(Credit credit) {
        return new CreditDto(credit.getId(), credit.getClientName(), credit.getPercent(), credit.getPeriod(),
                credit.getMonthlyPayment(), credit.getSum(), credit.getRequisites());
    }
}
