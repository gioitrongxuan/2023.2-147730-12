package com.jmc.htdh.subsystemSQLServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLServerConnection {
    private Connection conn;

    public SQLServerConnection() {
        // Thay đổi các thông tin kết nối phù hợp với SQL Server của bạn
        String url = "jdbc:sqlserver://DESKTOP-7RDGHEM\\SQLEXPRESS:1434;databaseName=HTDHNK;trustServerCertificate=true;";
        String user = "sa";
        String password = "123456789";
        try {
            this.conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connect successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getBPDHQTDataBase(String username, String password) {
        ResultSet resultSet = null;
        String query = "SELECT * FROM BPDHQT WHERE username = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet getRejectOrderDataBase(){
        ResultSet resultSet = null;
        String query = "SELECT * FROM Order WHERE status = 'REJECTED'";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
