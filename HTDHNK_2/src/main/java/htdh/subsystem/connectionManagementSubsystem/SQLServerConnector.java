package htdh.subsystem.connectionManagementSubsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLServerConnector implements DatabaseConnector{
    private DatabaseConfig config;
    private Connection connection;

    public SQLServerConnector() {
       this.config = new DatabaseConfig();
    }
    public SQLServerConnector(DatabaseConfig config) {
        this.config = config;
     }
    

    public ResultSet getBPDHQTDataBase(String username, String password) {
        ResultSet resultSet = null;
        String query = "SELECT * FROM account WHERE username = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
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
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    @Override
    public void connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = DriverManager.getConnection(this.config.getUrl(), this.config.getUsername(), this.config.getPassword());
            System.out.println("Connected to SQL Server database.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Failed to load SQL Server JDBC driver.");
            e.printStackTrace();
    }
}


    @Override
    public void disconnect() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
                System.out.println("Disconnected from SQL Server database.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to disconnect from SQL Server database.");
            e.printStackTrace();
        }
    }
}
