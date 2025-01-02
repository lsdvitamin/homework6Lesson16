package ru.otus.homework6.lesson16.dao;

import ru.otus.homework6.lesson16.DataSourceSingltone;
import ru.otus.homework6.lesson16.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei on 17.11.2024 19:22.
 * @project homework6Lesson16
 */
public class ItemsDao {
    public static Connection connection = null;
    public static Statement statement;
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;

    public ItemsDao() {
        connection = DataSourceSingltone.getInstance().getConnection();
        createTable();
    }

    public void createTable() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS items (id int8, title varchar, price numeric(10,2))";
            statement = connection.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(Item item) {
        try {
            String sql = "INSERT INTO items (id, title, price) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, item.getId());
            preparedStatement.setString(2, item.getTitle());
            preparedStatement.setInt(3, item.getPrice());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void priceX2(Item item) {
        try {
            String sql = "UPDATE items SET price=price*2 WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, item.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Item> selectAll() throws SQLException {
        List<Item> items = new ArrayList();
        try {
            String sql = "SELECT id, title, price FROM items";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setTitle(resultSet.getString("title"));
                item.setPrice(resultSet.getInt("price"));
                items.add(item);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return items;
    }


    public void delete(Item item) {
        try {
            String sql = "DELETE FROM items WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, item.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void truncateTable() {
        try {
            String sql = "truncate table items";
            statement = connection.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConn() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

}
