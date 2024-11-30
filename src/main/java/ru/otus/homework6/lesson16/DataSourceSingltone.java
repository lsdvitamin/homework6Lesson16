package ru.otus.homework6.lesson16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Sergei on 30.11.2024 18:39.
 * @project homework6Lesson16
 */
public class DataSourceSingltone {

    private Connection connection;
    private String url = "jdbc:postgresql://192.168.10.249:5432/student";
    private String username = "student";
    private String password = "student";

    private static final DataSourceSingltone INSTANCE = new DataSourceSingltone();

    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to PostgreSQL JDBC");
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public DataSourceSingltone() {
    }

    public static DataSourceSingltone getInstance() {
        return INSTANCE;
    }

}
