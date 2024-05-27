package htdh.subsystem.connectionManagementSubsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class PostgreSQLConnector implements DatabaseConnector {
    private DatabaseConfig config;
    private Connection connection;

    public PostgreSQLConnector(DatabaseConfig config) {
        this.config = config;
    }
    
    public PostgreSQLConnector() {
        this.config = new DatabaseConfig();
    }

    @Override
    public void connect() {
        try {
            Class.forName("org.postgresql.Driver"); 
            
            connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());

            System.out.println("Connected to PostgreSQL database.");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load PostgreSQL JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to PostgreSQL database.");
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from PostgreSQL database.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to disconnect from PostgreSQL database.");
            e.printStackTrace();
        }
    }
}