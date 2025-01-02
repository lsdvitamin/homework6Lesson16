package ru.otus.homework6.lesson16.Service;

import ru.otus.homework6.lesson16.Item;
import ru.otus.homework6.lesson16.dao.ItemsDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei on 24.11.2024 20:58.
 * @project homework6Lesson16
 */
public class ItemsService implements Service {
    ItemsDao crudItemsDao;
    List<Item> items;
    static Connection conn;


    public ItemsDao getCrudItemsDao() {
        return crudItemsDao;
    }
    public ItemsService() {
        crudItemsDao = new ItemsDao();
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void readAllRowsFromItems() throws SQLException {
        items = crudItemsDao.selectAll();
    }

    public void createOneHundredItems() {
        for (int i = 0; i < 100; i++) {
            items.add(new Item(i, "Bread" + i, (int) (Math.random() * 999) + 1));
        }
        for (Item item : items) {
            crudItemsDao.insert(item);
        }
    }

    public void updatePriceX2() throws SQLException {
        for (Item item : crudItemsDao.selectAll()) {
            crudItemsDao.priceX2(item);
        }
        items = crudItemsDao.selectAll();
    }

    public void truncateTable() {
        crudItemsDao.truncateTable();
    }

    public void closeConn() {
        crudItemsDao.closeConn();
    }

    @Override
    public void run() throws SQLException {
        createOneHundredItems();
        readAllRowsFromItems();
    }

}
