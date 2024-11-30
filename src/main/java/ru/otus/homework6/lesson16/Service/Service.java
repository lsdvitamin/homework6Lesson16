package ru.otus.homework6.lesson16.Service;

import java.sql.SQLException;

/**
 * @author Sergei on 30.11.2024 19:54.
 * @project homework6Lesson16
 */
public interface Service {

    void createOneHundredItems() throws SQLException;

    void updatePriceX2() throws SQLException;

    void truncateTable();

    void closeConn();

}
