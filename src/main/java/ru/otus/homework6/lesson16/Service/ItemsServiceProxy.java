package ru.otus.homework6.lesson16.Service;

import ru.otus.homework6.lesson16.Item;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei on 24.11.2024 22:48.
 * @project homework6Lesson16
 */
public class ItemsServiceProxy implements Service {
    private ItemsService service;
    private final List<Item> items;

    public ItemsServiceProxy() {
        items = new ArrayList<>();
    }

    public void updatePriceX2() throws SQLException {
        if (service == null) {
            service = new ItemsService();
            service.run();
            items.addAll(service.getItems());
        } else {
            service.updatePriceX2();
            service.readAllRowsFromItems();
        }
    }

    @Override
    public void run() throws SQLException {
        if(service == null) {
            service = new ItemsService();
            service.run();
            items.addAll(service.getItems());
        }
        else
            service.readAllRowsFromItems();
    }

    public void closeConn() {
        service.closeConn();
    }

}
