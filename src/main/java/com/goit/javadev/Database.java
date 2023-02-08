package com.goit.javadev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String DB_URL = "jdbc:h2:~/test;DB_CLOSE_ON_EXIT=TRUE;FILE_LOCK=NO";
    private static Database instance;
    private Connection connection;

    private Database() throws SQLException {
        createConnection();
    }

    private void createConnection() throws SQLException {
        connection = DriverManager.getConnection(DB_URL);
    }

    public static Database getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            createConnection();
        }

        return connection;
    }
}
