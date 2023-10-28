package com.company.rest.dto;


import com.company.domain.CardAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardAccountDto {

    private int id; //номер договора

    private String clientName; //Имя клиента

    private String birthday;

    private String accountCodeWord; //Кодовое слово, необходимое для восстановления карты

    private String accountNumber; //Номер счета, к которому привязаны карты

    private String cardNumber;

    public static CardAccount toDomainObject(CardAccountDto cardAccountDto) {
        return new CardAccount(cardAccountDto.getId(), cardAccountDto.getClientName(), cardAccountDto.getBirthday(),
                cardAccountDto.getAccountCodeWord(), cardAccountDto.getAccountNumber(), cardAccountDto.getCardNumber());
    }

    public static CardAccountDto toDto(CardAccount cardAccount) {
        return new CardAccountDto(cardAccount.getId(), cardAccount.getClientName(), cardAccount.getBirthday(),
                cardAccount.getAccountCodeWord(), cardAccount.getAccountNumber(), cardAccount.getCardNumber());
    }
}
