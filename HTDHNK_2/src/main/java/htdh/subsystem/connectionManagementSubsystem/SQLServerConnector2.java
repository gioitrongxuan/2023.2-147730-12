package htdh.subsystem.connectionManagementSubsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnector2 implements DatabaseConnector{
    private Connection connection;

    private static final String URL = "jdbc:sqlserver://DESKTOP-LIBGL2T\\SQLEXPRESS:1433;databaseName=HTDHNK;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "123456789";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error connecting to the database", e);
        }
        return connection;
    }


    @Override
    public void connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = getConnection();
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

