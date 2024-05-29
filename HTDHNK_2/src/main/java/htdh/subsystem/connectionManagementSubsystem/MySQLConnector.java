package htdh.subsystem.connectionManagementSubsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector implements DatabaseConnector {
    private DatabaseConfig config;
    private Connection connection;

    public MySQLConnector(DatabaseConfig config) {
        this.config = config;
    }
    public MySQLConnector() {
        this.config = new DatabaseConfig();
    }

    @Override
    public void connect() {
        try {
            this.connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
            System.out.println("Database Connect successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            this.connection.close();
            System.out.println("Database Disconnect successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}