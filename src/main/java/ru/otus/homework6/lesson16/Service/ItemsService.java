package ru.otus.homework6.lesson16.Service;

import ru.otus.homework6.lesson16.Item;
import ru.otus.homework6.lesson16.dao.ItemsDao;

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

    @Override
    public void createOneHundredItems() {
        for (int i = 0; i < 100; i++) {
            items.add(new Item(i, "Bread" + i, (int) (Math.random() * 999) + 1));
        }
        for (Item item : items) {
            crudItemsDao.insert(item);
        }
    }

    @Override
    public void updatePriceX2() throws SQLException {
        for (Item item : crudItemsDao.selectAll()) {
            crudItemsDao.priceX2(item);
        }
        items = crudItemsDao.selectAll();
    }

    @Override
    public void truncateTable() {
        crudItemsDao.truncateTable();
    }

    @Override
    public void closeConn() {
        crudItemsDao.closeConn();
    }


}
