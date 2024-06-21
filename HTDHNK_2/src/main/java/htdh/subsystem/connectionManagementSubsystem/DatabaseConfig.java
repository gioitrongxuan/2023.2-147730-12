package htdh.subsystem.connectionManagementSubsystem;

public class DatabaseConfig {
    //Default values
<<<<<<< HEAD
    private String url = "jdbc:sqlserver://DESKTOP-HTS59DT\\NTD2003:1433;databaseName=HTDHNK;trustServerCertificate=true;";
=======
    private String url = "jdbc:sqlserver://DESKTOP-LIBGL2T\\SQLEXPRESS:1433;databaseName=HTDHNK;trustServerCertificate=true;";
>>>>>>> 7ac4fe243b4e948c54b5bdaa33a67c1e26c047bc
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