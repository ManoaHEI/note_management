package com.notes.notesmanagement.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    
    private static Connection connection;

    private DatabaseConnection() {
        try {
            Properties properties = new Properties();
            FileInputStream input = new FileInputStream("src/main/resources/application.properties");
            properties.load(input);

            String dbUrl = properties.getProperty("spring.datasource.url");
            String dbUsername = properties.getProperty("spring.datasource.username");
            String dbPassword = properties.getProperty("spring.datasource.password");

            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

            input.close();
        } catch (IOException | SQLException e) {
            System.out.println("Error while connecting to the database : " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            new DatabaseConnection();
        }

        return connection;
    }
}