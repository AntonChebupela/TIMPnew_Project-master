package com.company.service;


import com.company.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibDemoService implements LibDemo{

    private final AccountService accountService;
    private final CardAccountService cardAccountService;
    private final DepositService depositService;
    private final CreditService creditService;
    private final CardService cardService;
    private final ClientService clientService;

    public void accountDemo() {
        List<Account> accountList = accountService.getAll();

        System.out.println("-------------");
        accountList.forEach(System.out::println);
        System.out.println("-------------");

        Account account = Account.builder().account("123").balance(111.11).build();
        accountService.insert(account);
        accountList = accountService.getAll();

        System.out.println("-------------");
        accountList.forEach(System.out::println);
        System.out.println("-------------");
    }

    public void depositDemo() {
        List<Deposit> depositList = depositService.getAll();

        System.out.println("-------------");
        depositList.forEach(System.out::println);
        System.out.println("-------------");

        Deposit dep = Deposit.builder()
                .name("Шевченко")
                .sum("5000")
                .period("20 лет")
                .percent("10%")
                .requisites("123412312")
                .abilityTopUp("Да")
                .abilityWithdraw("Да").build();
        depositService.insert(dep);

        depositList = depositService.getAll();
        depositList.forEach(System.out::println);
        System.out.println("-------------");
    }

    public void creditDemo() {
        List<Credit> creditList = creditService.getAll();

        System.out.println("-------------");
        creditList.forEach(System.out::println);
        System.out.println("-------------");

        Credit cr = Credit.builder()
                .clientName("Шевченко")
                .percent("30%")
                .period("20 лет")
                .monthlyPayment("10000")
                .sum("100000000")
                .requisites("213123").build();

        creditService.insert(cr);

        creditList = creditService.getAll();
        System.out.println("-------------");
        creditList.forEach(System.out::println);
        System.out.println("-------------");
    }

    public void caDemo() {
        List<CardAccount> cardAccountList = cardAccountService.getAll();

        System.out.println("-------------");
        cardAccountList.forEach(System.out::println);
        System.out.println("-------------");

        CardAccount ca = CardAccount.builder()
                .clientName("Шевченко")
                .birthday("11.01.99")
                .accountCodeWord("Математика")
                .accountNumber("12")
                .cardNumber("12312").build();

        cardAccountService.insert(ca);
        cardAccountList = cardAccountService.getAll();

        System.out.println("-------------");
        cardAccountList.forEach(System.out::println);
        System.out.println("-------------");
    }

    public void cardDemo() {
        List<Card> cardList = cardService.getAll();

        System.out.println("-------------");
        cardList.forEach(System.out::println);
        System.out.println("-------------");

        Card newCard = Card.builder()
                .number(123124)
                .cardPeriod("23.1")
                .personName("Воронежский")
                .cvv("122")
                .codeForCheckCVV("CodeForCheckCVV")
                .pinCode("1111")
                .account_id(1)
                .build();

        cardService.insert(newCard);
        cardList = cardService.getAll();

        System.out.println("-------------");
        cardList.forEach(System.out::println);
        System.out.println("-------------");
    }


    public void clientDemo() {
        List<Client> clientList = clientService.getAll();

        System.out.println("-------------");
        for (Client cl : clientList) {
            System.out.println(cl.toString());
        }
        System.out.println("-------------");

        Client client = Client.builder()
                .id(2)
                .name("Шевченко")
                .birthday("11.01.99")
                .credits(1)
                .cardAccount(2)
                .deposits(2)
                .build();

        clientService.insert(client);
        clientList = clientService.getAll();

        clientList.forEach(System.out::println);
    }

}
