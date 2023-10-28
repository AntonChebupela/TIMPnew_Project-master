package com.company;

import com.company.domain.*;
import com.company.repository.*;
import com.company.service.LibDemo;
import com.company.service.LibDemoService;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;
import java.util.List;


// url h2 консоли: http://localhost:8081/h2-console
// url базы: jdbc:h2:mem:testdb

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

//        try {
//            //Консоль для визуализации бд в браузере
//            Console.main(args);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        LibDemo libDemo = context.getBean(LibDemo.class);
//        libDemo.accountDemo();
//        libDemo.depositDemo();
//        libDemo.creditDemo();
//        libDemo.caDemo();
//        libDemo.cardDemo();
//        libDemo.clientDemo();

//        context.close();
    }
}

