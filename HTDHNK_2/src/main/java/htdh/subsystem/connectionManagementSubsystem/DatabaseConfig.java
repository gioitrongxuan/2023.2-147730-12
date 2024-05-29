package htdh.subsystem.connectionManagementSubsystem;

public class DatabaseConfig {
    //Default values
    private String url = "jdbc:sqlserver://DESKTOP-LIBGL2T\\SQLEXPRESS:1433;databaseName=HTDHNK;trustServerCertificate=true;";
    private String username = "sa";
    private String password = "123456789";
//chỗ này là thông tin dâtbase của máy ông 
//thế cais số hiệu cổng kia là sao: OK MAF LÚC NÃY TÔI PUSH LÊN XONG KO THÁY CỦA TÔI ĐÂU LUÔN:đđ
//    NÊN MỚI PHẢI CLONE LẠI:đđ
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