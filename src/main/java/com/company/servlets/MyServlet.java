package com.company.servlets;

import com.company.rest.controller.WebController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.WebConnection;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equals("/")) {
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().print("<html>" +
                    "<head>" +
                    "<title>Главная страница</title>" +
                    "</head>" +
                    "<body>" +
                    "<h1 align = center>Главная страница банка</h1>" +
                    "<p align = center><a href = /authorisecl>Я клиент</a></p>" +
                    "<p> </p>" +
                    "<p> </p>" +
                    "<p align = center style = padding: 5px 10px><a href = /authoriseworker>Я сотрудник</a></p>" +
                    "</body></html>");

        }
        if (req.getRequestURI().equals("/authorisecl")) {
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().print("<html><title>Авторизация клиента</title>" +
                    "<head>" +
                    "</head>" +
                    "<body>" +
                    "<h1 align = center>Авторизация</h1>" +
                    "<p align = center>Введите ваш логин</p>" +
                    "<form method = post name = form align = center> " +
                    "<br>" +
                    "Фамилия: <input name = surname type = text value =>" +
                    "" +
                    "<input type = submit name = send value = Отправить>"  +
                    "</form>" +
                    "<p align = center><a href = /clientprofile>Далее</a></p>" +
                    "</body>" +
                    "</html>");
        }
        if (req.getRequestURI().equals("/authoriseworker")) {
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().print("<html><title>Авторизация сотрудника</title>" +
                    "<head>" +
                    "</head>" +
                    "<body>" +
                    "<h1 align = center>Авторизация</h1>" +
                    "<p align = center>Здесь будет авторизация сотрудника</p>" +
                    "<p align = center><a href = /workerprofile>Далее</a></p>" +
                    "</body>" +
                    "</html>");
        }
        if (req.getRequestURI().equals("/clientprofile")) {
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().print("<html><title>Клиентская страница</title>" +
                    "<head>" +
                    "</head>" +
                    "<body>" +
                    "<h1 align = center>Клиентская страница</h1>" +
                    "<p></p>" +
                    "<p align = center><a href = /clientprofile/clientcr>Информация о кредитах</a></p>" +
                    "<p align = center><a href = /clientprofile/clientdep>Информация о депозитах</a></p>" +
                    "<p align = center><a href = /clientprofile/clientca>Информация о карточных продуктах</a></p>" +
                    "<p align = center><a href = /newproduct>Открыть новый продукт</a></p>" +
                    "</body>" +
                    "</html>");
        }
        if (req.getRequestURI().equals("/workerprofile")) {
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().print("<html>" +
                    "<title>Страница работника</title>" +
                    "<head></head>" +
                    "<body><h1 align = center>Страница сотрудника</h1>" +
                    "<p align = center><a href = /workerprofile/findClientInfo>Найти клиента</a></p>" +
                    "<p align = center><a href = />Рассмотреть входящие заявки</a></p>" +
                    "<p align = center><a href = /newproduct>Открыть новый продукт</a></p>" +
                    "<p></p>" +
                    "</body>" +
                    "</html>");
        }
        if (req.getRequestURI().equals("/clientprofile/clientcr")) {
            resp.setContentType("text/html; charset=utf-8");

        }
        if (req.getRequestURI().equals("/clientprofile/clientdep")) {

        }
        if (req.getRequestURI().equals("/clientprofile/clientca")) {

        }
        if (req.getRequestURI().equals("/newproduct")) {
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().print("<html><title>Открытие нового продукта</title>" +
                    "<head>" +
                    "</head>" +
                    "<body>" +
                    "<h1 align = center>Открытие нового продукта</h1>" +
                    "<form method = post name = form align = center> " +
                    "<br>" +
                    "Фамилия: <input name = surname type = text value =><br><br>" +
                    "Имя: <input name = name type = text value =><br><br>" +
                    "Отчество: <input name = name type = text value =><br><br>" +
                    "Ваша дата рождения: <input name = name type = date value =><br><br>" +
                    "<select name=product><br><br>" +
                    "<option value=Credit> Кредит"+
                    "<option value=Deposit> Депозит"+
                    "<option value=Card> Дебетовая карта"+
                    "</select>" +
                    "<br><br>"+
                    "<input type = submit name = send value = Отправить заявку>"  +
                    "</form>" +
                    "<p align = center><a href = /clientprofile>Вернуться назад</a></p>" +
                    "</body>" +
                    "</html>");
        }
    }
}
