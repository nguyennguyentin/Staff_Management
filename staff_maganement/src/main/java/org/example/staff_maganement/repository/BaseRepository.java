package org.example.staff_maganement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseRepository {
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/staff_management";
    private static final String USER = "root";
    private static final String PASS = "123456";

    public BaseRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            // Kiểm tra nếu kết nối đang đóng hoặc chưa được tạo thì tạo kết nối mới
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Connected to the database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
