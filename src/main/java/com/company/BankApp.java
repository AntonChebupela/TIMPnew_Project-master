package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// url h2 консоли: http://localhost:8081/h2-console
// url базы: jdbc:h2:mem:testdb

@SpringBootApplication
public class BankApp {

    public static void main(String[] args) {
        SpringApplication.run(BankApp.class, args);
    }
}

