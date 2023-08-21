package com.notes.notesmanagement.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class DatabaseConnection {

    private static Queue<Connection> connectionPool = new ArrayBlockingQueue<>(10);

    static {
        try {
            Properties properties = new Properties();
            FileInputStream input = new FileInputStream("application.properties");
            properties.load(input);

            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");

            for (int i = 0; i < 10; i++) {
                Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                connectionPool.add(connection);
            }

            input.close();
        } catch (IOException | SQLException e) {
            System.out.println("Error while initializing connection pool: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        Connection connection = connectionPool.poll();
        if (connection == null) {
            System.out.println("All connections are busy. Please try again later.");
        }
        return connection;
    }

    public static void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                connectionPool.add(connection);
            } catch (IllegalStateException e) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("Error while closing connection: " + ex.getMessage());
                }
            }
        }
    }
}