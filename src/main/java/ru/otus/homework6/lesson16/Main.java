package ru.otus.homework6.lesson16;

import ru.otus.homework6.lesson16.Service.ItemsServiceProxy;
import ru.otus.homework6.lesson16.Service.Service;

import java.sql.SQLException;


/**
 * @author Sergei on 13.11.2024 20:29.
 * @project Default (Template) Project
 */
public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        Service service = new ItemsServiceProxy();
        service.run();
        System.out.println("Сгенерировал строки");
        Thread.sleep(5000);
        service.updatePriceX2();
        System.out.println("Обновил цену");
        service.closeConn();
    }
}
