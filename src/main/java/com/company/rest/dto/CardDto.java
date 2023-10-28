package com.company.rest.dto;


import com.company.domain.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {

    private int number; //Номер карты

    private String cardPeriod; //Срок действия карты

    private String personName; //Фио на карте

    private String cvv; //CVV код на обратной стороне карты

    private String codeForCheckCVV; //Код для проверки

    private String pinCode;

    private int account_id;

    public static Card toDomainObject(CardDto cardDto) {
        return new Card(cardDto.getNumber(), cardDto.getCardPeriod(), cardDto.getPersonName(), cardDto.getCvv(),
                cardDto.getCodeForCheckCVV(), cardDto.getPinCode(), cardDto.getAccount_id());
    }

    public static CardDto toDto(Card card) {
        return new CardDto(card.getNumber(), card.getCardPeriod(), card.getPersonName(), card.getCvv(),
                card.getCodeForCheckCVV(), card.getPinCode(), card.getAccount_id());
    }

}
