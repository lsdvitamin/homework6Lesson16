package ru.otus.homework6.lesson16;

import ru.otus.homework6.lesson16.Service.ItemsServiceProxy;
import ru.otus.homework6.lesson16.Service.Service;

import java.sql.SQLException;


/**
 * @author Sergei on 13.11.2024 20:29.
 * @project Default (Template) Project
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Service service = new ItemsServiceProxy();
        service.createOneHundredItems();
        service.updatePriceX2();
        service.truncateTable();
        service.closeConn();
    }
}
