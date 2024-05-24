package htdh.subsystem.connectionManagementSubsystem;

public class DatabaseConfig {
    //Default values
    private String url = "jdbc:sqlserver://LAPTOP-RVP7SFPH:1433;databaseName=HTDHNK;trustServerCertificate=true;";
    private String username = "sa";
    private String password = "123456789";


    // Constructor, getters, and setters
    public DatabaseConfig(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    public DatabaseConfig() {
    }

    // Getters and setters
    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}