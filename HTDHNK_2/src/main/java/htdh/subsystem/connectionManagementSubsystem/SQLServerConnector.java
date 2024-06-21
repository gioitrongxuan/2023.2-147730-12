package htdh.subsystem.connectionManagementSubsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import htdh.common.entity.Merchandise;
import htdh.common.entity.Product;
import htdh.model.common.entity.Order;
import htdh.model.common.entity.Order_Merchandise;
import htdh.subsystem.CanceledOrder.DeleteRejectOrder;
import htdh.subsystem.CanceledOrder.GetCanceledOrder;
import htdh.subsystem.CanceledOrder.ListSite;


public class SQLServerConnector implements DatabaseConnector{

    private DatabaseConfig config;
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

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

    public void createOrder(ArrayList<Merchandise> data) {
        String query = "INSERT INTO Order (merchandiseCode, quantity, unit, year, month, day, status) VALUES (?, ?, ?, ?, ?, ?,?)";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            for (Merchandise merchandise : data) {
                preparedStatement.setString(1, merchandise.getMerchandiseCode());
                preparedStatement.setInt(2, merchandise.getQuantityOrdered());
                preparedStatement.setString(3, merchandise.getUnit());
                preparedStatement.setInt(4, merchandise.getYear());
                preparedStatement.setInt(5, merchandise.getMonth());
                preparedStatement.setInt(6, merchandise.getDay());
                preparedStatement.setString(7, "Wait");
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product findProductByMerchandiseCode(String merchandiseCode) {
        String query = "SELECT merchandiseCode, unit FROM Product WHERE merchandiseCode = ?";
        ArrayList<String> units = new ArrayList<>();
        Product product = null;

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, merchandiseCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String code = resultSet.getString("merchandiseCode");
                String[] elements = resultSet.getString("unit").split(",");
                units = new ArrayList<String>(Arrays.asList(elements));
                product = new Product(code, units);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }



    public List<Order> getCanceledOrders() {
        return new GetCanceledOrder().getCanceledOrders();
    }
    public List<Order_Merchandise> getOrderMerchandises (String orderId){return new  GetCanceledOrder().getOrderMerchandise(orderId);}
    public ResultSet findListSite(String merchandiseCode,String siteID) {
        return  new ListSite().findListSite(merchandiseCode,siteID);
    }
    public void deleteCancelOrder(String orderId){
        new DeleteRejectOrder().deleteCancelOrder(orderId);
    }
}
